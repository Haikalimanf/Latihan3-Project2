package com.example.intentproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_pindah -> {
                val pindahIntent = Intent(this, SecondActivity::class.java)
                startActivity(pindahIntent)
            }
            R.id.btn_pindah_denganData -> {
                val pindahDataIntent = Intent(this, SecondActivity::class.java)
                pindahDataIntent.putExtra(PindahDenganData.EXTRA_NAME, "Haikal Iman")
                pindahDataIntent.putExtra(PindahDenganData.EXTRA_AGE, 22)
                startActivity(pindahDataIntent)
            }
        }
    }
}