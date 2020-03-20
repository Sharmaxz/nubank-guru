package com.example.nubank_guru

import android.os.Bundle
import android.content.Intent
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.nubank_guru.activities.LevelActivity
import com.example.nubank_guru.services.LevelService


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent = Intent(this, LevelActivity::class.java)
        startActivity(intent)
        finish()
    }
}
