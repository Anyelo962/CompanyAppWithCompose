package com.example.companyapp.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.companyapp.model.Address
import com.example.companyapp.model.Client
import kotlinx.coroutines.flow.Flow


@Dao
interface AddressDao {


    @Query("SELECT * FROM address")
    fun getAllAddress(): Flow<List<Address>>

    @Insert
    suspend fun addAddress(address: Address)

    @Delete
    suspend fun removeAddress(client: Client)


}