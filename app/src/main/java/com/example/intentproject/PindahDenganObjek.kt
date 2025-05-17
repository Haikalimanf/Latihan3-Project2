package com.example.intentproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentproject.databinding.ActivityPindahDenganObjekBinding

class PindahDenganObjek : AppCompatActivity() {

    private lateinit var binding: ActivityPindahDenganObjekBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPindahDenganObjekBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()}" + "\n Email : ${person.email.toString()}" + "\n Age : ${person.age.toString()}" + "City : ${person.city.toString()}"
        binding.txtObjek.text = text

    }

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
}