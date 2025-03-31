package com.dmribeiro87.dragonballapi.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dmribeiro87.dragonballapi.data.models.Character
import com.dmribeiro87.dragonballapi.databinding.ItemCharacterBinding

class CharacterAdapter(
    val context: Context
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    private var listCharacters = emptyList<Character>()
    private var action: ((Character) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount() = listCharacters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindViews(listCharacters[position])
    }

    fun updateCharacters(characters: List<Character>) {
        listCharacters = characters
        notifyDataSetChanged()
    }

    fun setAction(action: (Character) -> Unit) {
        this.action = action
    }

    inner class CharacterViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindViews(character: Character) {
            binding.apply {
                tvLabelName.text = character.name
                tvValueRaceGender.text = "${character.race} - ${character.gender}"
                tvValueKi.text = character.ki.toString()
                tvValueKi.text = character.ki.toString()
                tvValueTotalKi.text = character.maxKi.toString()
                tvValueAffiliation.text = character.affiliation
            }

            Glide.with(context)
            .load(character.image)
            .into(binding.ivCharacter)

            binding.cvCharacter.setOnClickListener {
                action?.invoke(character)
            }

        }
    }
}