package com.high.test.register.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.high.test.character.model.CharacterModel
import com.high.test.character.repositories.CharacterRepository

class RegisterViewModel(application: Application) : AndroidViewModel(application)  {

    var toast = MutableLiveData<String>()
    private val repository = CharacterRepository(application)


    fun createAccount(name:String,type:String): Boolean {


        if(name.isEmpty()) {
            toast.value = "O nome do jogador não pode ser vázio"
            return false
        }

        if(type.isEmpty()) {
            toast.value = "selecione uma classe para jogar e tente novamente"
            return false
        }

        repository.save(CharacterModel(name,type));
        return true;

        }
    }
