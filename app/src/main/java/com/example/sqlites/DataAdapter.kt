package com.example.sqlites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DataAdapter(private val context: Context, private val userArrayList: ArrayList<User>) :
    BaseAdapter() {
    private inner class ViewHolder {
        var name: TextView? = null
        var gender: TextView? = null
        var ageNumber: TextView? = null
        var studentNumber: TextView? = null

    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        val holder: ViewHolder

        if (view == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.view_datas, null, true)

            holder.name = view!!.findViewById(R.id.view_name)
            holder.gender = view.findViewById(R.id.view_gender)
            holder.ageNumber = view.findViewById(R.id.view_age)
            holder.studentNumber = view.findViewById(R.id.view_StudentNumber)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        holder.name!!.text = "Name: " + userArrayList[p0].getNames()
        holder.gender!!.text = "Gender: " + userArrayList[p0].getGender()
        holder.ageNumber!!.text = "Ages: " + userArrayList[p0].getageNumber()
        holder.studentNumber!!.text = "StudentNumber: " + userArrayList[p0].getSnumber()

        return view
    }

    override fun getItem(p0: Int): Any {

        return userArrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return userArrayList.size
    }


}