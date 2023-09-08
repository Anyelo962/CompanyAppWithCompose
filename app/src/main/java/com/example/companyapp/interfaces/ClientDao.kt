package com.example.companyapp.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.companyapp.model.Client
import com.example.companyapp.model.Company
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Query("SELECT*FROM Client")
    fun getAllClient(): Flow<List<Client>>

    @Upsert
    suspend fun addClient( client: Client)

    @Delete
    suspend fun removeClient(client: Client)

}