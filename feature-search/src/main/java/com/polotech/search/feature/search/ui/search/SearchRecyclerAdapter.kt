package com.polotech.search.feature.search.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polotech.search.feature.search.databinding.ItemCharacterSearchBinding
import com.polotech.search.feature.search.models.CharacterPresenter
import com.polotech.search.feature.search.ui.search.SearchRecyclerAdapter.SearchViewHolder.Companion.from

class SearchRecyclerAdapter (private val onClickListener: OnClickListener) :
    ListAdapter<CharacterPresenter, SearchRecyclerAdapter.SearchViewHolder>(SearchDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character, onClickListener)
    }


    class SearchViewHolder(private val binding: ItemCharacterSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterPresenter, onClickListener: OnClickListener) {
            binding.character = character
            binding.clickListener = onClickListener

        }

        companion object {
            fun from(parent: ViewGroup): SearchViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val searchBinding = ItemCharacterSearchBinding.inflate(inflater, parent, false)

                return SearchViewHolder(searchBinding)
            }
        }

    }

    class OnClickListener(private val onClickListener: (character: CharacterPresenter) -> Unit) {
        fun onClick(character: CharacterPresenter) = onClickListener(character)
    }

    class SearchDiffUtil : DiffUtil.ItemCallback<CharacterPresenter>() {
        override fun areItemsTheSame(
            oldItem: CharacterPresenter, newItem: CharacterPresenter
        ): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: CharacterPresenter, newItem: CharacterPresenter
        ): Boolean {
            return oldItem == newItem
        }

    }
}