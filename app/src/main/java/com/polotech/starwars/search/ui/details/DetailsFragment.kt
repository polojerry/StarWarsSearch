package com.polotech.starwars.search.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.polotech.starwars.search.databinding.DetailsFragmentBinding
import com.polotech.starwars.search.models.FilmPresenter
import com.polotech.starwars.search.models.PlanetPresenter
import com.polotech.starwars.search.models.Results
import com.polotech.starwars.search.models.SpeciesPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(inflater, container, false).apply {
            detailsViewModel = viewModel
            toolbarCharacterDetails.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        viewModel.characterPlanet.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    Toast.makeText(
                        requireContext(),
                        "Failed to load Planets${result.throwable.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Results.Success -> {
                    displayPlanet(result.data)
                }

                is Results.Loading -> {
                    Toast.makeText(requireContext(), "Loading Planets", Toast.LENGTH_SHORT).show()
                }
            }
        }

      /*  viewModel.characterFilms.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    Toast.makeText(
                        requireContext(),
                        "Failed to load Films${result.throwable.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Results.Success -> {
                    displayFilms(result.data)
                }

                is Results.Loading -> {
                    Toast.makeText(requireContext(), "Loading Films", Toast.LENGTH_SHORT).show()
                }
            }
        }
*/
        /*viewModel.characterFilms.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    Toast.makeText(
                        requireContext(),
                        "Failed ${result.throwable.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Results.Success -> {
                    displayFilms(result.data)
                }

                is Results.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.characterSpecies.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    Toast.makeText(
                        requireContext(),
                        "Failed ${result.throwable.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Results.Success -> {
                    displaySpecies(result.data)
                    Toast.makeText(
                        requireContext(),
                        "Success ${result.data.size}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is Results.Loading -> {
                    Toast.makeText(requireContext(), "Loading Species", Toast.LENGTH_SHORT).show()
                }
            }
        }*/
    }

    private fun displaySpecies(data: List<SpeciesPresenter>) {
        binding.species = data[0]
        binding.executePendingBindings()
        Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun displayFilms(data: List<FilmPresenter>) {

    }

    private fun displayPlanet(data: PlanetPresenter) {
        binding.planet  = data
    }

}