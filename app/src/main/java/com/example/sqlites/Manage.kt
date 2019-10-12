package com.example.sqlites


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView


class Manage : AppCompatActivity() {
    private var listView: ListView? = null
    private var userArrayList: ArrayList<User>? = null
    private var data_adapter: DataAdapter? = null
    private var databaseHandler: DatabaseHandler? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_viewdatas)
        listView = findViewById(R.id.list_view)
        databaseHandler = DatabaseHandler(this)
        userArrayList = databaseHandler!!.getAllUsers
        data_adapter = DataAdapter(this, this!!.userArrayList!!)
        listView!!.adapter = data_adapter

    }

}







