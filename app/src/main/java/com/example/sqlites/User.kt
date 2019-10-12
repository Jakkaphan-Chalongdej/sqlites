package com.example.sqlites

class User {
    var Name: String? = null
    var Genders : String? = null
    var id: Int = 0
    var ageNumber:String? = null
    var Number: String? = null

    fun getIds(): Int {
        return id
    }
    fun setIds(id: Int) {
        this.id = id
    }

    fun getNames(): String {
        return Name.toString()
    }
    fun getGender(): String {
        return Genders.toString()
    }
    fun getageNumber(): String {
        return ageNumber.toString()
    }

    fun getSnumber(): String {
        return Number.toString()
    }
    fun setNames(name: String) {
        this.Name = name
    }
    fun setGender(gender: String) {
        this.Genders = gender
    }
    fun setageNumber(agenumber: String) {
        this.ageNumber = agenumber
    }
    fun setnumber(nuber: String) {
        this.Number = nuber
    }





}