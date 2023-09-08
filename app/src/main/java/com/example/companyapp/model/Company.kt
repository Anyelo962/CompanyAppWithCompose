package com.example.companyapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Company")
data class Company(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val name:String
)
