package com.example.companyapp.repository

import com.example.companyapp.interfaces.ClientDao
import com.example.companyapp.interfaces.IClientRepository
import com.example.companyapp.model.Client
import kotlinx.coroutines.flow.Flow

class ClientRepository(
    private val clientDao: ClientDao
): IClientRepository {
    override suspend fun addClient(client: Client) {
       return clientDao.addClient(client)
    }

    override suspend fun deleteClient(client: Client) {
        return clientDao.removeClient(client = client)
    }

    override fun getAllClient(): Flow<List<Client>> {
        return clientDao.getAllClient()
    }


}