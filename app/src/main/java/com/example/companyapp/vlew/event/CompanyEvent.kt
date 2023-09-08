package com.example.companyapp.vlew.event

sealed class AddCompanyEvent {
    data class OnNamechange(val title:String): AddCompanyEvent()
    object OnSaveCompanyClick: AddCompanyEvent()
}