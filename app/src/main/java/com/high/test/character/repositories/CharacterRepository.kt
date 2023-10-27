package com.high.test.character.repositories

import android.content.Context
import com.high.test.character.database.CharacterDB
import com.high.test.character.model.CharacterModel

class CharacterRepository(context: Context) {

    private var characterList = mutableListOf<CharacterModel>()

    private var dao = CharacterDB.getInstance(context).getCharacterDao()


    fun save(characterModel: CharacterModel) {
        return dao.insert(characterModel)
    }

    fun delete(characterModel: CharacterModel) {
        dao.delete(characterModel)
    }

    fun getCharacter(id: Int) : CharacterModel {
        return dao.getCharacterById(id)
    }

    fun getAllCharacters() : List<CharacterModel> {
        characterList = dao.getAll().toMutableList()
        return dao.getAll()
    }

    fun update(characterModel: CharacterModel){
        dao.update(characterModel)
    }

    fun getElement(): Int {
        return characterList.size
    }

}