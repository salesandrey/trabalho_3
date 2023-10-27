package com.high.test.character.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.high.test.character.model.CharacterModel

@Dao
interface CharacterDAO {

    @Query("SELECT * FROM character")
    fun getAll(): List<CharacterModel>

    @Query("SELECT * FROM character WHERE uid = :id")
    fun getCharacterById(id: Int) : CharacterModel

    @Insert
    fun insert(character: CharacterModel)

    @Delete
    fun delete(character: CharacterModel)

    @Update
    fun update(character: CharacterModel)
}