package com.polotech.starwars.search.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.polotech.starwars.domain.models.error.ErrorModel
import com.polotech.starwars.search.databinding.SearchFragmentBinding
import com.polotech.starwars.search.models.Results
import com.polotech.starwars.search.ui.search.SearchRecyclerAdapter.OnClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var binding: SearchFragmentBinding
    private lateinit var adapter: SearchRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false).apply {
            layoutSearch.textSearch.doOnTextChanged { text, _, _, _ ->
                viewModel.searchCharacter(text.toString())

            }
        }

        setUpDisplay()

        return binding.root
    }

    private fun setUpDisplay() {
        adapter = SearchRecyclerAdapter(OnClickListener { character ->
            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(character)
            findNavController().navigate(action)
        })

        binding.recyclerViewSearch.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.character.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    when (result.error) {
                        is ErrorModel.Network -> {
                            Toast.makeText(
                                requireContext(),
                                "Error: Check your Internet Connection",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            Toast.makeText(
                                requireContext(),
                                "Error: Unknown Error",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    binding.layoutShimmerSearch.shimmerLayoutSearch.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    binding.layoutShimmerSearch.shimmerLayoutSearch.visibility = View.INVISIBLE
                    adapter.submitList(result.data)
                }

                is Results.Loading -> {
                    binding.layoutShimmerSearch.shimmerLayoutSearch.startShimmer()
                    binding.layoutShimmerSearch.shimmerLayoutSearch.visibility = View.VISIBLE
                    toggleSearchIllustrationVisibility(View.INVISIBLE)
                }
            }

        }
    }

    private fun toggleSearchIllustrationVisibility(visibility : Int){
        binding.layoutSearchIllustration.visibility = visibility
    }

}