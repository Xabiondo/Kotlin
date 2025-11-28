    package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

                InicioPage()

            }
        }
    }
}

    

@Composable
fun InicioPage(){
    Column (modifier = Modifier
        .padding(all = 50.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ) {
        Contador(Modifier.weight(1f))

    }
}

@Composable
fun Contador(modifier: Modifier ){
    var contadorPuntos  =   remember {mutableIntStateOf(0)}

    Column( modifier = Modifier
        .padding(40.dp)
    , horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center

        ) {

        Text("Contador" ,
            fontWeight = FontWeight.Bold ,
            fontSize = 30.sp)
        Text(contadorPuntos.value.toString() ,
            fontSize = 30.sp ,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(30.dp))

        Row {

            Button(
                onClick = {
                    contadorPuntos.value = contadorPuntos.value + 1

                } ,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)

            ) {
                Text(" + " ,
                    fontWeight = FontWeight.Bold ,
                    fontSize = 30.sp)
            }
            Button(
                onClick = {
                    if (contadorPuntos.value > 0){
                        contadorPuntos.value = contadorPuntos.value -1

                    }

                } ,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta) ,


            ) {
                Text(" - " ,
                    fontWeight = FontWeight.Bold ,
                    fontSize = 30.sp
                )
            }

        }
        Spacer(Modifier.height(30.dp))
        Button(
            onClick = {
                contadorPuntos.value = 0
            }
        ) {
            Icon(
                painter = painterResource(R.drawable.backbutton) ,
                contentDescription = "goBack" ,
                modifier = Modifier
                    .width(30.dp)

            )
        }

    }

}
