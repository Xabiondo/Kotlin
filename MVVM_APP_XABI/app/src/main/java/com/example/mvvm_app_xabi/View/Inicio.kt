package com.example.mvvm_app_xabi.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mvvm_app_xabi.viewModel.LoginViewModel

@Composable
fun Inicio(navController: NavController){

    val viewModel : LoginViewModel  = viewModel()

    Column {
        Buscador(Modifier.weight(100f))
    }



}
@Composable
fun Buscador(modifier: Modifier){

    var busqueda by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 50.dp)) {

        TextField(
            value = busqueda ,
            onValueChange = {busqueda = it},
            label = { Text("Que quieres buscar") }

        )
        Button(
            onClick = {


            }
        ) { }

    }


}