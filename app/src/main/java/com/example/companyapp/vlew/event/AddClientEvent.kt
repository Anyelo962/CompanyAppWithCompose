package com.example.companyapp.vlew.event

sealed class AddClientEvent{
    data class OnNamechange(val name:String): AddClientEvent()
    data class OnLastNamechange(val lastName:String): AddClientEvent()
    object OnSaveClientClick: AddClientEvent()
}
