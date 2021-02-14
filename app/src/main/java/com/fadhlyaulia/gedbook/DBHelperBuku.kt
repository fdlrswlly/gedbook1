package com.fadhlyaulia.gedbook

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelperBuku(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "Books.db"
        val DATABASE_VERSION = 1
        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBInfo.BookInput.TABLE_NAME + " (" + DBInfo.BookInput.COL_ID +
                    " VARCHAR(200) PRIMARY KEY, " + DBInfo.BookInput.COL_JUDUL + " TEXT, " +
                    DBInfo.BookInput.COL_PENGARANG + " VARCHAR(200), " + DBInfo.BookInput.COL_TAHUN_TERBIT +
                    " VARCHAR(200), " + DBInfo.BookInput.COL_PENERBIT + " TEXT, " + DBInfo.BookInput.COL_HARGA + " VARCHAR(200))"
        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBInfo.BookInput.TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertData(
        idin: String,
        judulin: String,
        pengarangin: String,
        tahunterbitin: String,
        penerbitin: String,
        hargain: String
    ): Boolean {
        val db = writableDatabase
        val namatablet = DBInfo.BookInput.TABLE_NAME
        val idt = DBInfo.BookInput.COL_ID
        val judult = DBInfo.BookInput.COL_JUDUL
        val pengarangt = DBInfo.BookInput.COL_PENGARANG
        val tahunterbitt = DBInfo.BookInput.COL_TAHUN_TERBIT
        val penerbit = DBInfo.BookInput.COL_PENERBIT
        val hargat = DBInfo.BookInput.COL_HARGA
        var sql =
            "INSERT INTO " + namatablet + "(" + idt + ", " + judult + ", " + pengarangt + ", " + tahunterbitt + ", " + penerbit + "," + hargat + ") " +
                    "VALUES('" + idin + "', '" + judulin + "', '" + pengarangin + "', '" + tahunterbitin + "','" + penerbitin + "','" + hargain + "')"
        db.execSQL(sql)
        return true
    }

    fun fullData(): ArrayList<DataModelBuku> {
//        val users = ArrayList<DBModel>()
        //val users = arrayListOf<DBModel>()
        val books = arrayListOf<DataModelBuku>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM " + DBInfo.BookInput.TABLE_NAME, null)
        } catch (e: SQLException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var idt: String
        var judult: String
        var pengarangt: String
        var tahunterbitt: String
        var penerbit: String
        var hargat: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                idt = cursor.getString(cursor.getColumnIndex(DBInfo.BookInput.COL_ID))
                judult = cursor.getString(cursor.getColumnIndex(DBInfo.BookInput.COL_JUDUL))
                pengarangt = cursor.getString(cursor.getColumnIndex(DBInfo.BookInput.COL_PENGARANG))
                tahunterbitt =
                    cursor.getString(cursor.getColumnIndex(DBInfo.BookInput.COL_TAHUN_TERBIT))
                penerbit = cursor.getString(cursor.getColumnIndex(DBInfo.BookInput.COL_PENERBIT))
                hargat = cursor.getString(cursor.getColumnIndex(DBInfo.BookInput.COL_HARGA))

                books.add(DataModelBuku(idt, judult, pengarangt, tahunterbitt, penerbit, hargat))
                cursor.moveToNext()
            }
        }
        return books
    }

    fun deleteData(idin: String){
        val db = writableDatabase
        val namatablet = DBInfo.BookInput.TABLE_NAME
        val idt = DBInfo.BookInput.COL_ID
        val sql = "DELETE FROM " +namatablet+ " WHERE "+idt+"='"+idin+"'"
        db.execSQL(sql)
    }
    fun updateData(idin: String, judulin: String, pengarangin: String, tahunterbitin: String, penerbitin: String, hargain: String) {
        val db = writableDatabase
        val namatablet = DBInfo.BookInput.TABLE_NAME
        val idt = DBInfo.BookInput.COL_ID
        val judult = DBInfo.BookInput.COL_JUDUL
        val pengarangt = DBInfo.BookInput.COL_PENGARANG
        val tahunterbitt = DBInfo.BookInput.COL_TAHUN_TERBIT
        val penerbit = DBInfo.BookInput.COL_PENERBIT
        val hargat = DBInfo.BookInput.COL_HARGA
        var sql = "UPDATE " + namatablet + " SET " +
                judult + "='" + judulin + "', " + pengarangt + "= '" + pengarangin + "', " +
                tahunterbitt + "= '" + tahunterbitin + "', " + penerbit + "= '" + penerbitin + "', " + hargat + "='" + hargain + "' " +
                "WHERE " + idt + "= '" + idin + "'"
        db.execSQL(sql)
    }

}


