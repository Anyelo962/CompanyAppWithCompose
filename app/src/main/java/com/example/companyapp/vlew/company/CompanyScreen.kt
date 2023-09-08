package com.example.companyapp.vlew.company

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.companyapp.util.UiEvent
import com.example.companyapp.viewmodel.CompanyViewModel
import com.example.companyapp.vlew.event.AddCompanyEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: CompanyViewModel = hiltViewModel()
){

    val listcompany = viewModel.listCompany.collectAsState(initial = emptyList())


    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{ event ->
            when(event){
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message,
                        actionLabel = event.action)
                }

                else -> Unit
            }

        }
    }

    Column {
        Text(text = "Agregar Compania",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 15.dp, top = 30.dp),
            
        )
        Spacer(modifier = Modifier.padding(top = 15.dp))

        OutlinedTextField(value = viewModel.nameCompany,
            onValueChange = {viewModel.onEvent(AddCompanyEvent.OnNamechange(it))},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            placeholder = {
                Text(text = "Agregar empresa")
            }
            )

        Button(onClick = { CoroutineScope(Dispatchers.IO).launch {
            viewModel.onEvent(AddCompanyEvent.OnSaveCompanyClick)
        } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 10.dp)) {
            Text(text = "Agregar empresa")
        }

        Spacer(modifier = Modifier.padding(top = 20.dp))
        LazyColumn{
            items(listcompany.value){
                Text(text = it.name, modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400)
                Divider()
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanySc(){

    var test:String by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        Text(text = "Agregar Compania",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 15.dp)
            )
        Spacer(modifier = Modifier.padding(top = 15.dp))

        OutlinedTextField(value = test,
            onValueChange = { test = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp))

        Button(onClick = { CoroutineScope(Dispatchers.IO).launch {

        } }, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp)) {
            Text(text = "Agregar empresa")
        }

    }
//
//    LazyColumn{
//        items(){
//
//        }
//    }
    
}


@Composable()
@Preview(showSystemUi = true, showBackground = true)
fun CompanyScPreview(){
    CompanySc()
}