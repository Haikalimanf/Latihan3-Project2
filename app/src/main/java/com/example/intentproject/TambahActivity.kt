package com.example.intentproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentproject.databinding.ActivityMainBinding
import com.example.intentproject.databinding.ActivityTambahBinding

class TambahActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityTambahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambahData.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
             R.id.btn_tambah_data -> {
                 if (binding.rgGender.checkedRadioButtonId != 0) {
                     var valueGender: String = ""
                     when (binding.rgGender.checkedRadioButtonId) {
                         R.id.laki_laki -> valueGender = "Laki Laki"
                         R.id.perempuan -> valueGender = "Perempuan"
                     }
                     val resultIntent = Intent()
                     resultIntent.putExtra(EXTRA_VALUE, valueGender)
                     setResult(RESULT_CODE, resultIntent)
                     finish()
                 }
             }
        }
    }

    companion object {
        const val EXTRA_VALUE = "extra_value"
        const val RESULT_CODE = 110
    }
}