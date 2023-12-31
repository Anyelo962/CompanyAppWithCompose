package com.example.companyapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Client(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val name:String,
    val lastName:String
)
