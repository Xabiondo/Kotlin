package com.example.mvvm_app_xabi.View


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mvvm_app_xabi.viewModel.LoginViewModel

@Composable
fun Login(navController: NavController){
    val viewModel: LoginViewModel = viewModel();
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(horizontal = 50.dp)
    ) {
        LogoApp(Modifier.weight(20f))
        LoginCampos(Modifier.weight(80f) , viewModel , navController )
    }
}
@Composable
fun LogoApp( modifier : Modifier){
    Column(modifier =   modifier) {
    }
}
@Composable
fun LoginCampos(modifier: Modifier, viewModel: LoginViewModel , navController: NavController){
    var nombre by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var mostrarError by remember {mutableStateOf(false)}

    if (mostrarError) {
        AlertDialog(
            onDismissRequest = { mostrarError = false },
            title = { Text("Error") },
            text = { Text("Usuario o contraseña incorrectos") },
            confirmButton = {
                TextButton(onClick = { mostrarError = false }) {
                    Text("Aceptar")
                }
            }
        )
    }

    Column (modifier) {
        TextField(
            value = nombre ,
            onValueChange = {nombre = it},
            label = { Text("Introduce tu texto") } ,

        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = contraseña ,
            onValueChange = {contraseña = it},
            label = { Text("Introduce tu contraseña") } ,
            )
        Button(
            onClick = {
                val loginCorrecto = viewModel.probarLogin(nombre , contraseña)
                if (loginCorrecto){
                    navController.navigate("Inicio")
                }else{
                    println("Login incorrecto")
                    mostrarError = true
                }

            }
        ) {
            Text("prueba a logearte ")
        }

    }

}