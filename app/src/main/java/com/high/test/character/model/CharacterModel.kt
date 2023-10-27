package com.high.test.character.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
class CharacterModel(
    @ColumnInfo @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "level") var level: Int = 1,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "strength") var strength: Int = 1,
    @ColumnInfo(name = "gear") var gear: Int = 0,
    @ColumnInfo(name = "modifier") var modifier: Int = 0){

    constructor(name:String,type: String) : this(0,1,name, type,1,0,0)
}