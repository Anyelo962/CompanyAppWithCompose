package com.example.companyapp.interfaces

import com.example.companyapp.model.Address
import com.example.companyapp.model.Client
import com.example.companyapp.model.Company
import kotlinx.coroutines.flow.Flow

interface IClientRepository {

    suspend fun addClient(client: Client)

    suspend fun deleteClient(client: Client)
    suspend fun addAddress(address: Address)

    fun getAllClient(): Flow<List<Client>>

    fun getLastClient(): Flow<Client>

}