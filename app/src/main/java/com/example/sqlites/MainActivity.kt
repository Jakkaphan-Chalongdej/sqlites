package com.example.sqlites



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var btnsave: Button? = null
    private var btnshow: Button? = null
    private var etname: EditText? = null
    private var etgender: EditText? = null
    private var etsnumber: EditText? = null
    private var etsage_number: EditText? = null
    private var databaseHandler: DatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseHandler = DatabaseHandler(this)
        btnsave = findViewById(R.id.button_save)
        btnshow = findViewById(R.id.button_show)
        etname = findViewById(R.id.editText_Name)
        etgender = findViewById(R.id.editText_gender)
        etsage_number = findViewById(R.id.editText_Age)
        etsnumber = findViewById(R.id.editText_StudentNumber)

        btnsave!!.setOnClickListener {
            databaseHandler!!.addUser(etname!!.text.toString(), etgender!!.text.toString(),etsage_number!!.text.toString(), etsnumber!!.text.toString())
            etname!!.setText("")
            etgender!!.setText("")
            etsage_number!!.setText("")
            etsnumber!!.setText("")
            Toast.makeText(this, "Save Successfully!", Toast.LENGTH_SHORT).show()
        }
        btnshow!!.setOnClickListener {
            val intent = Intent(this, Manage::class.java)
            startActivity(intent)
        }

    }
}



