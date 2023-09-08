package com.example.companyapp.vlew.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenericButton(
    onClick: () -> Unit,
    titleButton:String,

    ){
    OutlinedButton(onClick = onClick, modifier = Modifier.fillMaxWidth()
        .padding(start = 15.dp, end = 15.dp)

    ) {
        Text(titleButton)
    }
}