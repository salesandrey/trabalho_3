package com.high.test.character.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.high.test.R
import com.high.test.character.viewmodel.CharactersViewModel
import com.high.test.databinding.ActivityListCharactersBinding
import com.high.test.register.view.RegisterView

class ListCharactersView : AppCompatActivity() {

    private lateinit var binding: ActivityListCharactersBinding
    private lateinit var composition: CharacterAdapter
    private lateinit var viewModel: CharactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = CharactersViewModel(this.application)

        composition = CharacterAdapter(this, viewModel.repository)
        binding.listCharacters.layoutManager = LinearLayoutManager(this)
        binding.listCharacters.adapter = composition


        binding.floatingButton.setOnClickListener{
            val intent = Intent(this, RegisterView::class.java)
            this.startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.restartList()
        composition.notifyDataSetChanged()
    }
}