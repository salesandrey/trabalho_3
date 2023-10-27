package com.high.test.character.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.high.test.R
import com.high.test.character.repositories.CharacterRepository
import com.high.test.details.view.DetailsView


class CharacterAdapter(private val context: Context,private val repository: CharacterRepository): RecyclerView.Adapter<CharacterHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.character_details, parent, false)
        return CharacterHolder(layout)
    }

    override fun getItemCount(): Int {
        return repository.getElement()
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val composition = repository.getAllCharacters()

        val result = when(composition[position].type) {
            "Curandeiro" -> "white_mage_icon"
            "Mago Negro" -> "black_mage_icon"
            "Guerreiro" -> "warrior_icon"
            "Criatura" -> "creature_icon"
            else -> ""
        }

        val resources = context.resources
        val resourceId = resources.getIdentifier(result, "drawable", context.packageName)

        holder.title.text = composition[position].name
        holder.level.text = composition[position].level.toString()
        holder.type.text =  composition[position].type
        holder.image.setImageResource(resourceId)
        holder.strength.text = composition[position].strength.toString()

        holder.title.setOnClickListener {
            val intent = Intent(context, DetailsView::class.java)
            intent.putExtra("position", composition[position].uid)
            context.startActivity(intent)
        }
    }
}