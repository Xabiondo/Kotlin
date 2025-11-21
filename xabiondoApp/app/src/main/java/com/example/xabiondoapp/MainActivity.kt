package com.example.xabiondoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.xabiondoapp.ui.theme.XabiondoAppTheme
import androidx.compose.runtime.getValue  // Para poder LEER el valor
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.input.TextFieldValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XabiondoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {


                    FormularioInicio()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Que pasa bastardo $name!",

        modifier = modifier.padding()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XabiondoAppTheme {
        Greeting("Android")
    }
}
@Composable
fun miPrimeraFuncion(){
    Column(modifier = Modifier.padding(all = 50.dp)) {
        Text(text = "hola chavales")
        Text(text = "sois bastardos")



    }

}
@Composable
fun ContadorBotones(){
    var contador by remember { mutableStateOf(0) }

    fun contadorSuma(){
        contador = contador +  1;
    }
    Row(modifier = Modifier.padding(all = 150.dp)) {
        Text(text = "llevas :  $contador clicks" )

        Button(
            onClick = {contadorSuma()}
        ) {
            Text("hola tocame")
        }
    }

}
@Composable
fun FormularioInicio(){
    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var edad by remember { mutableStateOf(TextFieldValue()) }
    var correo by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.padding(all = 50.dp)) {     TextField(
        value = nombre,
        onValueChange = {
            nombre = it;
        },
        label = {Text(text = "tu nombre")},
        placeholder = {Text(text = "tu nombre pon")}
    )
        TextField(
            value = edad,
            onValueChange = {
                edad = it;
            },
            label = {Text(text = "tu edad" )},
            placeholder = {Text(text = "tu edad pon ")}
        )
        TextField(
            value =  correo ,
            onValueChange = {
                correo = it;
            },
            label = {Text(text = "pon tu correo")},
            placeholder = {Text(text = "pon el correo crack")}
        )
    }



}