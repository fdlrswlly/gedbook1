package com.fadhlyaulia.gedbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapterBuku(private val listDataku: ArrayList<DataModelBuku>): RecyclerView.Adapter<DBAdapterBuku.CardViewHolder>() {
    inner class CardViewHolder(itemV: View) : RecyclerView.ViewHolder(itemV) {
        var tvjudul: TextView = itemV.findViewById(R.id.tv_judul)
        var tvpengarang: TextView = itemV.findViewById(R.id.tv_pengarang)
        var tvtahunterbit: TextView = itemV.findViewById(R.id.tv_tahun_terbit)
        var tvpenerbit: TextView = itemV.findViewById(R.id.tv_penerbit)
        var tvharga: TextView = itemV.findViewById(R.id.tv_harga)
        var btndelete: Button = itemV.findViewById(R.id.btn_deletecard)
        var btnupdate: Button = itemV.findViewById(R.id.btn_updatecard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dataku, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvjudul.text = dataku.judul
        holder.tvpengarang.text = dataku.pengarang
        holder.tvtahunterbit.text = dataku.tahun_terbit
        holder.tvpenerbit.text = dataku.penerbit
        holder.tvharga.text = dataku.harga

        /* holder.btndelete.setOnClickListener {
            var adapterDBHelper: DBHelper
            adapterDBHelper = DBHelper(holder.itemView.context)
            adapterDBHelper.deleteData(dataku.email)
            listDataku.removeAt(position)
            notifyDataSetChanged()
        }
*/
        /*holder.btnupdate.setOnClickListener {
            val pindahUpdAc = Intent(holder.itemView.context, UpdateActivity::class.java)
            val bundle = Bundle()
            bundle.putString("emailk", dataku.email)
            bundle.putString("usernamek", dataku.username)
            bundle.putString("fullnamek", dataku.fullname)
            bundle.putString("passk", dataku.pass)
            pindahUpdAc.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUpdAc)
        }

    */
    }


    override fun getItemCount(): Int {
        return listDataku.size
    }
}


