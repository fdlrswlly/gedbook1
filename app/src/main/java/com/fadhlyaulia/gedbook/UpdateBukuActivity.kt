package com.fadhlyaulia.gedbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateBukuActivity : AppCompatActivity() {
    lateinit var DBHelperBuku : DBHelperBuku
    lateinit var inputidbuku : EditText
    lateinit var inputjudul : EditText
    lateinit var inputpengarang : EditText
    lateinit var inputtahunterbit : EditText
    lateinit var inputpenerbit : EditText
    lateinit var inputharga : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_buku)
        inputidbuku = findViewById(R.id.input_idu)
        inputjudul = findViewById(R.id.input_judulu)
        inputpengarang = findViewById(R.id.input_pengarangu)
        inputpenerbit = findViewById(R.id.input_penerbitu)
        inputtahunterbit = findViewById(R.id.input_tahun_terbitu)
        inputharga = findViewById((R.id.input_hargau))
        val bundle = intent.extras
        if(bundle!=null){
            inputidbuku.setText(bundle.getString("idbukuk"))
            inputjudul.setText(bundle.getString("judulk"))
            inputpengarang.setText(bundle.getString("pengarangk"))
            inputpenerbit.setText(bundle.getString("penerbitk"))
            inputtahunterbit.setText(bundle.getString("tahunterbitk"))
            inputharga.setText(bundle.getString("hargak"))
        }

    }
   fun updateData(v: View){
       var idin = inputidbuku.text.toString()
       var judulin = inputjudul.text.toString()
       var pengarangin = inputpengarang.text.toString()
       var tahunterbitin = inputtahunterbit.text.toString()
       var penerbitin = inputpenerbit.text.toString()
       var hargain = inputharga.text.toString()
       DBHelperBuku.updateData(idin, judulin, pengarangin, tahunterbitin, penerbitin, hargain)
       var pindah = Intent(this, RvDbActivity::class.java)
       startActivity(pindah)
   }
    fun cancelData(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
}

