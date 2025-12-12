package com.example.mvvm_app_xabi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_app_xabi.View.Inicio
import com.example.mvvm_app_xabi.View.Login
import com.example.mvvm_app_xabi.ui.theme.MVVM_APP_XABITheme
import com.example.mvvm_app_xabi.viewModel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_APP_XABITheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController ,
                    startDestination ="Login"
                ){
                    composable ("Login"){
                        Login(navController)

                    }
                    composable("inicio") {
                        Inicio(navController)

                    }

                }


            }
        }
    }
}

