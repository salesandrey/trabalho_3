package com.high.test.character.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.high.test.R

class CharacterHolder(layout: View) : RecyclerView.ViewHolder(layout) {
    val title: TextView = layout.findViewById(R.id.name_character_txt)
    val strength:TextView = layout.findViewById(R.id.strength_character_txt)
    val image:ImageView = layout.findViewById(R.id.icon_character_image)
    val type: TextView = layout.findViewById(R.id.type_character_txt)
    val level:TextView = layout.findViewById(R.id.level_character_txt)
}