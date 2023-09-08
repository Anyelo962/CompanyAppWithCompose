package com.example.companyapp.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.companyapp.model.Company
import kotlinx.coroutines.flow.Flow

@Dao
interface CompanyDao {

    @Query("SELECT*FROM Company")
    fun getAllCompany(): Flow<List<Company>>

    @Upsert
    suspend fun addCompany( company: Company)

    @Delete
    suspend fun removeCompany(company: Company)

}