package com.example.intentproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*
    * Tanggal Pengerjaan : 18/05/2025
    * NIM : 10122196
    * Nama : Haikal Iman Firdaus
    * Kelas : IF-6
    */

    private lateinit var binding: ActivityMainBinding
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == TambahActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getStringExtra(TambahActivity.EXTRA_VALUE)
            binding.txtResult.text = "Jenis Kelamin anda adalah : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnPindah.setOnClickListener(this)
        binding.btnPindahDenganData.setOnClickListener(this)
        binding.btnPindahDenganObjek.setOnClickListener(this)
        binding.btnDial.setOnClickListener(this)
        binding.btnOpenAnotherApps.setOnClickListener(this)
        binding.btnForResult.setOnClickListener(this)
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
            R.id.btn_pindah_denganObjek -> {
                var person = Person(
                    "Jhon Doe",
                    22,
                    "john.doe@examplepetstore.com",
                    "Bandung"
                )
                val pindahObjekIntent = Intent(this, PindahDenganObjek::class.java)
                pindahObjekIntent.putExtra(PindahDenganObjek.EXTRA_PERSON, person)
                startActivity(pindahObjekIntent)
            }
            R.id.btn_dial -> {
                val phoneNumber = "08977233000"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_open_another_apps -> {
//                val url = "https://www.instagram.com/hakip_/"
//                val openAnotherAppsIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(openAnotherAppsIntent)

                val valuePackage = "com.google.android.youtube"
                val openAnotherAppsIntent = Intent(Intent.ACTION_MAIN)
                openAnotherAppsIntent.setPackage(valuePackage)
                startActivity(openAnotherAppsIntent)
            }
            R.id.btn_for_result -> {
                val forResultIntent = Intent(this, TambahActivity::class.java)
                resultLauncher.launch(forResultIntent)
            }
        }
    }
}