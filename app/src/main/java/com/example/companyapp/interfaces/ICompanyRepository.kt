package com.example.companyapp.interfaces

import com.example.companyapp.model.Company
import kotlinx.coroutines.flow.Flow

interface ICompanyRepository {

    suspend fun addCompany(company:Company)

    suspend fun deleteCompany(company: Company)

     fun getAllCompany(): Flow<List<Company>>

}