package com.nizar.bengkelelysium.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nizar.bengkelelysium.R
import com.nizar.bengkelelysium.databinding.ActivityMenuBinding
import com.nizar.bengkelelysium.ui.HomeActivity
import com.nizar.bengkelelysium.ui.add.TambahTransaksiActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)
        supportActionBar?.hide()

        // click listener
        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, TambahTransaksiActivity::class.java))
        }
    }
}
