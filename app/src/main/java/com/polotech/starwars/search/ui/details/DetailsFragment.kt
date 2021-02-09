package com.polotech.starwars.search.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.polotech.starwars.domain.models.error.ErrorModel
import com.polotech.starwars.search.R
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
                    handleErrors(result.error)
                    binding.shimmerLayoutDetails.layoutShimmerPlanet.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    binding.shimmerLayoutDetails.layoutShimmerPlanet.visibility = View.INVISIBLE
                    displayPlanet(result.data)
                }

                is Results.Loading -> {
                }
            }
        }

        viewModel.characterSpecies.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    handleErrors(result.error)
                    binding.shimmerLayoutDetails.layoutShimmerSpecie.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    displaySpecies(result.data)
                    binding.shimmerLayoutDetails.layoutShimmerSpecie.visibility = View.INVISIBLE
                }

                is Results.Loading -> {
                }
            }
        }

        viewModel.characterFilms.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Results.Failed -> {
                    handleErrors(result.error)
                    binding.shimmerLayoutDetails.layoutShimmerFilm.visibility = View.INVISIBLE
                }

                is Results.Success -> {
                    displayFilms(result.data)
                    binding.shimmerLayoutDetails.layoutShimmerFilm.visibility = View.INVISIBLE
                }

                is Results.Loading -> {
                }
            }
        }

        viewModel.generalError.observe(viewLifecycleOwner){
            handleErrors(it)
        }

    }

    private fun handleErrors(error: ErrorModel) {
        when (error) {
            is ErrorModel.Network -> {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_internet),
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_unknown),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun displaySpecies(data: List<SpeciesPresenter>) {
        when {
            data.isEmpty() -> {
                binding.species =
                    SpeciesPresenter("unavailable", "unavailable", "unavailable")
            }
            else -> {
                binding.species = data[0]
            }
        }
        binding.executePendingBindings()
        binding.layoutSpecie.visibility = View.VISIBLE
    }

    private fun displayFilms(data: List<FilmPresenter>) {
        filmAdapter.submitList(data)
        binding.layoutFilms.visibility = View.VISIBLE

    }

    private fun displayPlanet(data: PlanetPresenter) {
        binding.planet = data
        binding.layoutPlanet.visibility = View.VISIBLE
    }

}