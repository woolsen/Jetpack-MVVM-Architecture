package cn.woolsen.rickandmorty.ui.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cn.woolsen.rickandmorty.R
import cn.woolsen.rickandmorty.data.bean.Character
import cn.woolsen.rickandmorty.databinding.ViewCharacterBinding
import com.bumptech.glide.Glide
import timber.log.Timber

class CharacterAdapter : PagingDataAdapter<Character, CharacterAdapter.CharacterViewHolder>(CharacterComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)!!
        holder.bind(item)
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ViewCharacterBinding.bind(itemView)

        fun bind(character: Character) {
            Timber.d(character.toString())
            binding.name.text = character.name
            binding.state.text = (character.status + " - " + character.species)
            binding.location.text = character.location.name
            binding.origin.text = character.origin.name
            Glide.with(binding.root)
                .load(character.image)
                .into(binding.image)
        }
    }
}



object CharacterComparator : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}