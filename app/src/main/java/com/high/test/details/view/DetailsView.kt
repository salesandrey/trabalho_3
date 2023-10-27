package com.high.test.details.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.high.test.R
import com.high.test.databinding.ActivityDetailsViewBinding
import com.high.test.details.viewmodel.DetailsViewModel
import com.high.test.register.viewmodels.RegisterViewModel

class DetailsView : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsViewBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = DetailsViewModel(application,intent.getIntExtra("position", -1))

        binding.nameTitle.text = viewModel.character?.name.toString()
        binding.typeTitle.text = viewModel.character?.type.toString()
        binding.levelTitle.text = viewModel.character?.level.toString()
        binding.gearTitle.text = viewModel.character?.gear.toString()
        binding.modifierTitle.text = viewModel.character?.modifier.toString()
        binding.strengthTitle.text = viewModel.character?.strength.toString()


        val result = when(viewModel.character?.type.toString()) {
            "Curandeiro" -> "white_mage_icon"
            "Mago Negro" -> "black_mage_icon"
            "Guerreiro" -> "warrior_icon"
            "Criatura" -> "creature_icon"
            else -> ""
        }

        val result2 = when(viewModel.character?.type.toString()) {
            "Curandeiro" -> "white_mage"
            "Mago Negro" -> "black_mage"
            "Guerreiro" -> "warrior"
            "Criatura" -> "creature"
            else -> ""
        }



        val resources = application.applicationContext.resources

        val resourceId = resources.getIdentifier(result, "drawable", application.applicationContext.packageName)
        val resourceId2 = resources.getIdentifier(result2, "drawable", application.applicationContext.packageName)

        binding.iconImage.setImageResource(resourceId)
        binding.imageCenter.setImageResource(resourceId2)

        binding.deleteButton.setOnClickListener{
            viewModel.deletePlayer()
            finish()
        }

        binding.levelUp.setOnClickListener{
            viewModel.levelUP()
            binding.levelTitle.text = viewModel.character?.level.toString()
            binding.strengthTitle.text = viewModel.character?.strength.toString()
        }

        binding.levelDown.setOnClickListener{
            viewModel.levelDown()
            binding.levelTitle.text = viewModel.character?.level.toString()
            binding.strengthTitle.text = viewModel.character?.strength.toString()
        }

        binding.gearDown.setOnClickListener{
            viewModel.gearDown()
            binding.gearTitle.text = viewModel.character?.gear.toString()
            binding.strengthTitle.text = viewModel.character?.strength.toString()
        }

        binding.gearUp.setOnClickListener{
            viewModel.gearUp()
            binding.gearTitle.text = viewModel.character?.gear.toString()
            binding.strengthTitle.text = viewModel.character?.strength.toString()
        }

        binding.modifierDown.setOnClickListener{
            viewModel.modifierDown()
            binding.modifierTitle.text = viewModel.character?.modifier.toString()
            binding.strengthTitle.text = viewModel.character?.strength.toString()
        }

        binding.modifierUp.setOnClickListener{
            viewModel.modifierUp()
            binding.modifierTitle.text = viewModel.character?.modifier.toString()
            binding.strengthTitle.text = viewModel.character?.strength.toString()
        }
    }
}