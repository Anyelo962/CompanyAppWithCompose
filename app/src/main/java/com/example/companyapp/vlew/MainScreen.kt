package com.example.companyapp.vlew

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.companyapp.R
import com.example.companyapp.util.Routes
import com.example.companyapp.util.UiEvent
import com.example.companyapp.viewmodel.CompanyViewModel
import com.example.companyapp.vlew.component.GenericButton


@Composable
fun MainScreen( onNavigate: (UiEvent.Navigate) -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

        ) {

        Image(painter = painterResource(id = R.drawable.company_image), contentDescription ="Default",
            modifier = Modifier.padding(top = 100.dp))
        Spacer(modifier = Modifier.padding(10.dp))
        GenericButton(onClick = {
           onNavigate(UiEvent.Navigate(Routes.ADD_COMPANY))
        }, "Agregar empresa")

        Spacer(modifier = Modifier.padding(10.dp))
        GenericButton(onClick = {
            onNavigate(UiEvent.Navigate(Routes.CLIENT_SCREEN))
        }, "Agregar Cliente")

        Spacer(modifier = Modifier.padding(10.dp))
        GenericButton(onClick = {
            onNavigate(UiEvent.Navigate(Routes.ADDRESS_SCREEN))
        }, "Agregar dirección")
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainScreenPreview(){
    //MainScreen()
}