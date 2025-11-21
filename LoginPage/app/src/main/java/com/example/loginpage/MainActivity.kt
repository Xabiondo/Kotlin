package com.example.loginpage

import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpage.ui.theme.LoginPageTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPageTheme {

                Column (
                    modifier = Modifier.fillMaxSize()
                ){
                    primerTercio(Modifier.weight(3.33f))
                    segundoTercio(Modifier.weight(5f))
                    tercerTercio(Modifier.weight(1.7f))
                }


            }
        }
    }
}

@Composable
fun primerTercio(modifier: Modifier ){

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Red)
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )


        {
        Image(
            painter = painterResource(R.drawable.dragon),
            contentDescription = "icon",
            modifier = Modifier.size(50.dp)
        )
        }


}

@Composable
fun segundoTercio(modifier: Modifier){
    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember {mutableStateOf(TextFieldValue(""))}
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        TextField(
            value = nombre,
            onValueChange = {
                nombre = it;
            },
            label = {Text(text = "pon tu nombre")},
            placeholder = {Text(text = "pon aqui tu nombre")},
            trailingIcon = {Icon(
                painter = painterResource(R.drawable.dragon),
                contentDescription = "icon"
            )}


        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        TextField(
            value = password ,
            onValueChange = {
                password = it;
            },
            label =  {Text(text = "contraseña")},
            placeholder = {Text(text = "contraseña aqui")},
            trailingIcon ={ Icon(
                painter = painterResource(R.drawable.dragon),
                contentDescription = "icon")}

        )

        Button(onClick = {} ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)


            ) {
            Text("Login")

        }

    }

}

@Composable
fun tercerTercio(modifier: Modifier){

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(top = 50.dp)
            .padding(horizontal = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(text = "Footer , 3000" ,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center ,

            )

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginPageTheme {
        Greeting("Android")
    }
}