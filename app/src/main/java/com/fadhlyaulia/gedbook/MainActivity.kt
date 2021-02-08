package com.fadhlyaulia.gedbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addBuku : Button = findViewById(R.id.btn_tambah)
        addBuku.setOnClickListener{
            val intent = Intent(this, InputBukuActivity::class.java)
            startActivity(intent)
        }
        fun showAll(v:View){
            var pindah = Intent(this, RvDbActivity::class.java)
            startActivity(intent)
        }



    }
}