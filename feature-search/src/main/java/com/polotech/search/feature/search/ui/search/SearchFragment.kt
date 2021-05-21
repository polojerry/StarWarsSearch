package com.polotech.search.feature.search.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.polotech.search.feature.search.R
import com.polotech.search.feature.search.databinding.SearchFragmentBinding
import com.polotech.search.feature.search.models.CharacterPresenter
import com.polotech.search.feature.search.models.Results
import com.polotech.starwars.domain.models.error.ErrorModel
import com.polotech.search.feature.search.ui.search.SearchRecyclerAdapter.OnClickListener
import com.polotech.starwars.navigation.Navigation
import com.polotech.starwars.navigation.NavigationDestination
import com.polotech.starwars.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var binding: SearchFragmentBinding
    private lateinit var adapter: SearchRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false).apply {
            layoutSearch.textSearch.doOnTextChanged { text, _, _, _ ->
                viewModel.searchCharacter(text.toString())

            }
        }
        setUpDisplay()
        setUpSearchIllustration()

        return binding.root
    }

    private fun setUpDisplay() {
        adapter = SearchRecyclerAdapter(OnClickListener { character ->
            navigateToDetails(character)
            /*val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(character)
            findNavController().navigate(action)*/
        })
        binding.recyclerViewSearch.adapter = adapter
    }

    private fun navigateToDetails(character: CharacterPresenter) {
        (requireActivity() as Navigation).toNavigationDestination(NavigationDestination.CharacterDetails(character = character.url))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.character.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    when (result.error) {
                        is ErrorModel.Network -> {
                            setUpErrorIllustration()
                        }
                        else -> {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.error_unknown),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    toggleSearchRecyclerVisibility(View.INVISIBLE)
                    binding.layoutShimmerSearch.shimmerLayoutSearch.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    binding.layoutShimmerSearch.shimmerLayoutSearch.visibility = View.INVISIBLE
                    toggleSearchIllustrationVisibility(View.INVISIBLE)
                    submitResult(result.data)
                }

                is Results.Loading -> {
                    binding.layoutShimmerSearch.shimmerLayoutSearch.startShimmer()
                    binding.layoutShimmerSearch.shimmerLayoutSearch.visibility = View.VISIBLE
                    toggleSearchIllustrationVisibility(View.INVISIBLE)
                }
            }

        }
    }

    private fun submitResult(data: List<CharacterPresenter>){
        when {
            data.isEmpty() -> {
                setUpEmptyIllustration()
                toggleSearchRecyclerVisibility(View.INVISIBLE)

            }
            else -> {
                adapter.submitList(data)
                toggleSearchRecyclerVisibility(View.VISIBLE)
            }
        }
    }

    private fun setUpErrorIllustration() {
        bindIllustration(
            R.drawable.undraw_server_down_s4lk, resources.getString(R.string.illustration_network_error)
        )
    }

    private fun setUpSearchIllustration() {
        bindIllustration(
            R.drawable.ic_undraw_lost_online_wqob, resources.getString(R.string.illustration_search)
        )
    }

    private fun setUpEmptyIllustration() {
        bindIllustration(
            R.drawable.undraw_empty_xct9, resources.getString(R.string.illustration_empty_search)
        )
    }

    private fun bindIllustration(imageDrawable: Int, message: String) {
        toggleSearchIllustrationVisibility(View.VISIBLE)
        binding.imageSearchIllustration.load(imageDrawable)
        binding.textSearchIllustration.text = message
    }

    private fun toggleSearchIllustrationVisibility(visibility: Int) {
        binding.layoutSearchIllustration.visibility = visibility
    }

    private fun toggleSearchRecyclerVisibility(visibility: Int) {
        binding.recyclerViewSearch.visibility = visibility
    }

}