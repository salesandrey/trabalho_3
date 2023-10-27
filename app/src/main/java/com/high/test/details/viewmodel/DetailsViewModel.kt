package com.high.test.details.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import com.high.test.character.model.CharacterModel
import com.high.test.character.repositories.CharacterRepository

class DetailsViewModel (application: Application, index: Int) : AndroidViewModel(application)  {

    private val repository = CharacterRepository(application)
    var character: CharacterModel?
    var str = 0


    init {
        character = repository.getCharacter(index)
        str = character!!.strength
    }


    fun levelUP(){
        character?.level = character?.level!! + 1
        saveResult()
    }

    fun levelDown(){
        character?.level = character?.level!! - 1
        saveResult()
    }

    fun gearDown(){
        character?.gear = character?.gear!! - 1
        saveResult()
    }

    fun gearUp() {
        character?.gear = character?.gear!! + 1
        saveResult()
    }

    fun modifierUp(){
        character?.modifier = character?.modifier!! + 1
        saveResult()
    }

    fun modifierDown(){
        character?.modifier = character?.modifier!! - 1
        saveResult()
    }

    fun deletePlayer(){
        repository.delete(character!!)
    }

    private fun saveResult(){
        val strength: Int = (character?.level ?: 1) * 10 + ((character?.gear?.times(3) ?: 1) - (character?.modifier ?: 1) * 1)

        character?.strength = strength

        repository.update(characterModel = character!!)
    }

}