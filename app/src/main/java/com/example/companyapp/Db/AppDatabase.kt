package com.example.companyapp.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.companyapp.interfaces.AddressDao
import com.example.companyapp.interfaces.CompanyDao
import com.example.companyapp.interfaces.ClientDao
import com.example.companyapp.model.Address
import com.example.companyapp.model.Client
import com.example.companyapp.model.Company


@Database(entities = [Company::class, Client::class, Address::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract val companyDao: CompanyDao
    abstract val clientDao: ClientDao
    abstract val addressDao: AddressDao

}