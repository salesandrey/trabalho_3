package com.high.test.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.high.test.databinding.ActivityRegisterViewBinding
import com.high.test.register.viewmodels.RegisterViewModel

class RegisterView : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterViewBinding
    private  lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        showToast()

        binding.createButton.setOnClickListener {

            var type: String = ""

            if(binding.blackMage.isChecked){
                type = binding.blackMage.text.toString()
            } else if(binding.warrior.isChecked){
                type = binding.warrior.text.toString()
            } else if(binding.whiteMage.isChecked){
                type = binding.whiteMage.text.toString()
            } else if(binding.creature.isChecked){
                type = binding.creature.text.toString()
            } else{
                type = ""
            }

            if(viewModel.createAccount(binding.playerField.text.toString(),type)) {
                finish()
            }
        }
    }

    private fun showToast(){
        viewModel.toast.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}