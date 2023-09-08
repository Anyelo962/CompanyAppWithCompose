package com.example.companyapp.vlew.client

import android.content.Context
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.companyapp.R
import com.example.companyapp.model.Client
import com.example.companyapp.util.UiEvent
import com.example.companyapp.viewmodel.ClientViewModel
import com.example.companyapp.vlew.event.AddClientEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientScreen(onNavigate: (UiEvent.Navigate) -> Unit,
                  viewmodel:ClientViewModel = hiltViewModel()) {


    val context = LocalContext.current
    var result = viewmodel.getLastClient.collectAsState(initial = "")

    Column(modifier = Modifier.padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.client_image),
            contentDescription = "client image")

        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = viewmodel.name, onValueChange = {
                       viewmodel.onEvent(AddClientEvent.OnNamechange(it))
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp),
            placeholder = {
                Text(text = "Ingrese su nombre")
            }
        )

        Spacer(modifier = Modifier.padding(top = 15.dp))

        OutlinedTextField(value = viewmodel.lastName, onValueChange = {
            viewmodel.onEvent(AddClientEvent.OnLastNamechange(it))
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            placeholder = {
                Text(text = "Ingrese su apellido")
            })

        Spacer(modifier = Modifier.padding(top = 15.dp))

        OutlinedTextField(value = viewmodel.address, onValueChange = { viewmodel.onEvent(AddClientEvent.OnAddresschange(it))},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            placeholder = {
                Text(text = "Ingrese su dirección")
            })

        Spacer(modifier = Modifier.padding(top = 45.dp))

        OutlinedButton(onClick = {
            viewmodel.onEvent(AddClientEvent.OnSaveClientClick)

           // ToastMessage(context, result.value.toString())
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)) {
            Text(text = "Agregar cliente")

        }

    }



}


private fun ToastMessage (context:Context, text:String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ClientScreenPreview(){

 //   ClientScreen()


}