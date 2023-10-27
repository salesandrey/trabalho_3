package com.high.test.character.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.high.test.character.repositories.CharacterRepository

 public class CharactersViewModel(application: Application) : AndroidViewModel(application)  {

    val repository = CharacterRepository(application)

     init {
         repository.getAllCharacters()
     }

     fun restartList (){
         repository.getAllCharacters()
     }

}