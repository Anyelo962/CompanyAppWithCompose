package com.example.companyapp.interfaces

import com.example.companyapp.model.Address
import kotlinx.coroutines.flow.Flow

interface IAddressRepository {

    suspend fun addAddress(address: Address)

    fun getAddress():Flow<List<Address>>

}