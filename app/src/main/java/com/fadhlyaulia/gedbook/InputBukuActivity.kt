package com.fadhlyaulia.gedbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class InputBukuActivity : AppCompatActivity() {
    lateinit var DBHelperBuku: DBHelperBuku
    lateinit var inputid: EditText
    lateinit var inputjudul: EditText
    lateinit var inputpengarang: EditText
    lateinit var inputtahunterbit: EditText
    lateinit var inputpenerbit: EditText
    lateinit var inputharga: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_buku)
        inputid = findViewById(R.id.input_id)
        inputjudul = findViewById(R.id.input_judul)
        inputpengarang = findViewById(R.id.input_pengarang)
        inputtahunterbit = findViewById(R.id.input_tahun_terbit)
        inputpenerbit = findViewById(R.id.input_penerbit)
        inputharga = findViewById(R.id.input_harga)
        DBHelperBuku = DBHelperBuku(this)
    }
    fun addData(v: View){
        var idin = inputid.text.toString()
        var judulin = inputjudul.text.toString()
        var pengarangin = inputpengarang.text.toString()
        var tahunterbitin = inputtahunterbit.text.toString()
        var penerbitin = inputpenerbit.text.toString()
        var hargain = inputharga.text.toString()
        DBHelperBuku.insertData(idin,judulin, pengarangin, tahunterbitin, penerbitin,hargain)
        inputid.setText("")
        inputjudul.setText("")
        inputpengarang.setText("")
        inputtahunterbit.setText("")
        inputpenerbit.setText("")
        inputharga.setText("")

    }
    fun showAll(v:View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
}
}