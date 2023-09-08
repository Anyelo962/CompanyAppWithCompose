package com.example.companyapp.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.companyapp.model.Address
import com.example.companyapp.model.Client
import com.example.companyapp.model.Company
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Query("SELECT*FROM Client")
    fun getAllClient(): Flow<List<Client>>

    @Query("SELECT * FROM Client ORDER BY id DESC LIMIT 1")
    fun getLastClient(): Flow<Client>

    @Upsert
    suspend fun addClient( client: Client)

    @Insert
    suspend fun addAddress(address: Address)


    @Delete
    suspend fun removeClient(client: Client)

}