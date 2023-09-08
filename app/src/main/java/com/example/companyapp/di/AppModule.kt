package com.example.companyapp.di

import android.app.Application
import androidx.room.Room
import com.example.companyapp.Db.AppDatabase
import com.example.companyapp.repository.ClientRepository
import com.example.companyapp.repository.CompanyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCompanyDatabase(app:Application):
            AppDatabase = Room.databaseBuilder(app,
        AppDatabase::class.java, "CompanyDb")
                .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCompanyRepository(db: AppDatabase): CompanyRepository{
        return CompanyRepository(db.companyDao)
    }

    @Provides
    @Singleton
    fun provideClientRepository(db: AppDatabase): ClientRepository {
        return ClientRepository(db.clientDao)
    }

//
//    @Provides
//    @Singleton
//    fun provideAddressRepository(db: AppDatabase): AddressRepository{
//        return AddressRepository(db.addressDao)
//    }
//


}