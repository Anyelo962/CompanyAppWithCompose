package com.example.companyapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.companyapp.model.Company
import com.example.companyapp.repository.CompanyRepository
import com.example.companyapp.util.UiEvent
import com.example.companyapp.vlew.event.AddCompanyEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor (
    private val repository: CompanyRepository
): ViewModel() {


    var company by mutableStateOf<Company?>(null)

    var nameCompany by mutableStateOf("")
    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    val listCompany = repository.getAllCompany()
    fun onEvent(event: AddCompanyEvent){
        when(event){
            is AddCompanyEvent.OnNamechange -> {
                nameCompany = event.title
            }

            is AddCompanyEvent.OnSaveCompanyClick -> {
                viewModelScope.launch {

                    if(nameCompany.isBlank()){
                        SendUiEvent(UiEvent.ShowSnackbar(
                            message = "El nombre de la compania no puede estar vacio"
                        ))
                        return@launch
                    }


                    repository.addCompany(Company(
                        id = 0,
                        name = nameCompany
                    ))
                }
            }
        }
    }


    private fun SendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}
