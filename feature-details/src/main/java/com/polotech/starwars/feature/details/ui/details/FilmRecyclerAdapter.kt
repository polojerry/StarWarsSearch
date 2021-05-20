package com.polotech.starwars.feature.details.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polotech.starwars.feature.details.databinding.ItemFilmBinding
import com.polotech.starwars.feature.details.models.FilmPresenter

class FilmRecyclerAdapter :
    ListAdapter<FilmPresenter, FilmRecyclerAdapter.FilmViewHolder>(FilmDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmViewHolder {
        return FilmViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(film)
    }

    class FilmViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmPresenter) {
            binding.film = film
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): FilmViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val itemFilmBinding = ItemFilmBinding.inflate(inflater, parent, false)

                return FilmViewHolder(itemFilmBinding)
            }
        }


    }

    class FilmDiffUtil : DiffUtil.ItemCallback<FilmPresenter>() {
        override fun areItemsTheSame(oldItem: FilmPresenter, newItem: FilmPresenter): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: FilmPresenter, newItem: FilmPresenter): Boolean {
            return oldItem == newItem
        }

    }
}