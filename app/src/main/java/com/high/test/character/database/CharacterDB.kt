package com.high.test.character.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.high.test.character.dao.CharacterDAO
import com.high.test.character.model.CharacterModel

@Database(entities = [CharacterModel::class], version = 3, exportSchema = false)
abstract class CharacterDB : RoomDatabase() {

    abstract fun getCharacterDao(): CharacterDAO

    companion object{

        private lateinit var INSTANCE : CharacterDB

        fun getInstance(context: Context) : CharacterDB {

            if (!::INSTANCE.isInitialized) {

                INSTANCE = Room.databaseBuilder(context, CharacterDB::class.java, "characters_db")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE
        }
    }
}