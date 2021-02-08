package com.polotech.starwars.search.ui.details

import android.os.Bundle
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

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var binding: DetailsFragmentBinding

    private lateinit var filmAdapter: FilmRecyclerAdapter

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

        setupDisplay()
        return binding.root
    }

    private fun setupDisplay() {
        filmAdapter = FilmRecyclerAdapter()
        binding.recyclerViewFilm.adapter = filmAdapter
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
                    binding.layoutShimmerPlanet.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    binding.layoutShimmerPlanet.visibility = View.INVISIBLE
                    displayPlanet(result.data)
                }

                is Results.Loading -> {
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
                    binding.layoutShimmerSpecie.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    displaySpecies(result.data)
                    binding.layoutShimmerSpecie.visibility = View.INVISIBLE
                }

                is Results.Loading -> {
                }
            }
        }

        viewModel.characterFilms.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    Toast.makeText(
                        requireContext(),
                        "Failed ${result.throwable.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.layoutShimmerFilm.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    displayFilms(result.data)
                    binding.layoutShimmerFilm.visibility = View.INVISIBLE
                }

                is Results.Loading -> {
                }
            }
        }

    }

    private fun displaySpecies(data: List<SpeciesPresenter>) {
        if (data.isEmpty()) binding.species =
            SpeciesPresenter("unavailable", "unavailable", "unavailable")
        else data[0]
        binding.executePendingBindings()
        binding.layoutSpecie.visibility = View.VISIBLE
    }

    private fun displayFilms(data: List<FilmPresenter>) {
        filmAdapter.submitList(data)
        binding.recyclerViewFilm.visibility = View.VISIBLE

    }

    private fun displayPlanet(data: PlanetPresenter) {
        binding.planet = data
        binding.layoutPlanet.visibility = View.VISIBLE
    }

}