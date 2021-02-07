package com.polotech.starwars.search.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.polotech.starwars.domain.usecases.SearchCharacterUseCase
import com.polotech.starwars.search.databinding.SearchFragmentBinding
import com.polotech.starwars.search.di.UseCaseModule
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)

        viewModel.character.observe(viewLifecycleOwner){
            it.forEach {
                Toast.makeText(requireContext(), it.name, Toast.LENGTH_LONG).show()
            }

        }

        viewModel.searchCharacter("j")
        return binding.root
    }

}