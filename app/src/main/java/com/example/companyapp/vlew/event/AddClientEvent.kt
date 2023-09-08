package com.example.companyapp.vlew.event

sealed class AddClientEvent{
    data class OnNamechange(val name:String): AddClientEvent()
    data class OnLastNamechange(val lastName:String): AddClientEvent()
    data class OnAddresschange(val adddress:String): AddClientEvent()
    object OnSaveClientClick: AddClientEvent()
}
