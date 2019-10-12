package com.example.sqlites

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHandler (context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {
    companion object {
        private val DB_NAME = "UsersDB"
        private val DB_VERSIOM = 1
        private val TABLE_NAME = "users"
        private val ID = "id"
        private val NAME = "Name"
        private val GENDER = "Gender"
        private val AGE = "Age"
        private val SNUMBER = "StudentNumber"

    }
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE =
            "CREATE TABLE $TABLE_NAME ($ID Integer PRIMARY KEY, $NAME TEXT,$GENDER TEXT,$AGE TEXT,$SNUMBER TEXT)"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)

    }
    fun addUser(
        name: String,
        gender: String,
        Snumber: String,
        age: String
    ): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME, name)
        values.put(GENDER,gender)
        values.put(AGE,age)
        values.put(SNUMBER,Snumber)
        val _success = db.insert(TABLE_NAME,null,values )
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }
    //get  users
    val getAllUsers: ArrayList<User>
        get() {
        val userArrayList = ArrayList<User>()
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val user = User()
                    user.setIds(cursor.getInt(cursor.getColumnIndex(ID)))
                    user.setNames(cursor.getString(cursor.getColumnIndex(NAME)))
                    user.setGender(cursor.getString(cursor.getColumnIndex(GENDER)))
                    user.setageNumber(cursor.getString(cursor.getColumnIndex(AGE)))
                    user.setnumber(cursor.getString(cursor.getColumnIndex(SNUMBER)))
                    userArrayList.add(user)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return userArrayList
    }


}


