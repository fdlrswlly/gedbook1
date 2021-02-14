package com.fadhlyaulia.gedbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RvDbActivity : AppCompatActivity() {
    private lateinit var rv_tampilanku: RecyclerView
    lateinit var DBHelperBuku: DBHelperBuku
    private  var list: ArrayList<DataModelBuku> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_db)
        rv_tampilanku = findViewById(R.id.rv_tampilkan)
        rv_tampilanku.setHasFixedSize(true)
        DBHelperBuku = DBHelperBuku(this)
        list.addAll(DBHelperBuku.fullData())
        rv_tampilanku.layoutManager = LinearLayoutManager(this)
        var cardData = DBAdapterBuku(list)
        rv_tampilanku.adapter = cardData
    }
}