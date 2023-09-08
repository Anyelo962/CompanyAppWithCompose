package com.example.companyapp.repository

import com.example.companyapp.Db.AppDatabase
import com.example.companyapp.interfaces.CompanyDao
import com.example.companyapp.interfaces.ICompanyRepository
import com.example.companyapp.model.Company
import kotlinx.coroutines.flow.Flow

class CompanyRepository(
    private val dao: CompanyDao
): ICompanyRepository {
    override suspend fun addCompany(company: Company) =  dao.addCompany(company = company)

    override suspend fun deleteCompany(company: Company) =  dao.removeCompany(company = company)

    override  fun getAllCompany(): Flow<List<Company>> = dao.getAllCompany()
}