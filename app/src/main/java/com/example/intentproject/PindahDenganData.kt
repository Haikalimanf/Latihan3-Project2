package com.example.intentproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentproject.databinding.ActivityPindahDenganDataBinding

class PindahDenganData : AppCompatActivity() {

    private lateinit var binding: ActivityPindahDenganDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPindahDenganDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getStringExtra(EXTRA_AGE)
        val text = "Name : $name, Your Age : $age"
        binding.txtData.text = text
    }

    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
}