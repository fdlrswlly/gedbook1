package com.fadhlyaulia.gedbook

import android.provider.BaseColumns

object DBInfo {
    class UserInput : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COL_EMAIL = "email"
            val COL_PASS = "pass"
            val COL_USERNAME = "username"
            val COL_FULLNAME = "fullname"
        }
    }

    class BookInput : BaseColumns {
        companion object {
            val TABLE_NAME = "buku"
            val COL_ID ="id"
            val COL_JUDUL = "judul"
            val COL_PENGARANG = "pengarang"
            val COL_TAHUN_TERBIT = "tahunterbit"
            val COL_PENERBIT = "penerbit"
            val COL_HARGA = "harga"
        }
    }
}