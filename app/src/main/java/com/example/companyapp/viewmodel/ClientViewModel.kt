package com.example.companyapp.viewmodel

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companyapp.interfaces.IClientRepository
import com.example.companyapp.model.Client
import com.example.companyapp.model.Company
import com.example.companyapp.repository.ClientRepository
import com.example.companyapp.util.UiEvent
import com.example.companyapp.vlew.event.AddClientEvent
import com.example.companyapp.vlew.event.AddCompanyEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClientViewModel @Inject constructor(private val repository: ClientRepository): ViewModel()  {

    var name:String by mutableStateOf("")
    var lastName:String by mutableStateOf("")

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    val getAllClient = repository.getAllClient()


    fun onEvent(event: AddClientEvent){
        when(event){
            is AddClientEvent.OnNamechange -> {
                name = event.name
            }

            is AddClientEvent.OnLastNamechange -> {
                lastName = event.lastName
            }

            is AddClientEvent.OnSaveClientClick -> {
                viewModelScope.launch {

                    if(name.isBlank() || lastName.isBlank()){
                        SendUiEvent(UiEvent.ShowSnackbar(
                            message = "No puede haber campos vacio"
                        ))
                        return@launch
                    }



                    var result = repository.addClient(
                        Client(
                        id = 0,
                        name = name, lastName = lastName
                    )

                    )
                }
            }

            else -> Unit
        }
    }


    private fun SendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }





}