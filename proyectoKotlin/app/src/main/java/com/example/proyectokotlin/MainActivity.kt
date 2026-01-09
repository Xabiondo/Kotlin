package com.example.proyectokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectokotlin.ui.theme.ProyectoKotlinTheme
import com.example.proyectokotlin.view.ViewConfiguracion
import com.example.proyectokotlin.viewmodel.TrabajoViewModel
import com.example.proyectokotlin.view.ViewListado
import com.example.proyectokotlin.view.ViewFavoritas
import com.example.proyectokotlin.view.ViewPerfil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoKotlinTheme {
                AppPrincipal()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPrincipal() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    val viewModelCompartido: TrabajoViewModel = viewModel()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Trabajo Navarra") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = { /* Acción menú */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("perfil") }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Perfil")
                    }
                    IconButton(onClick = { navController.navigate("listado") }) {
                        Icon(Icons.Default.Home, contentDescription = "Inicio")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = currentRoute == "perfil",
                    onClick = { navController.navigate("perfil") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Listado") },
                    label = { Text("Listado") },
                    selected = currentRoute == "listado",
                    onClick = { navController.navigate("listado") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoritas") },
                    label = { Text("Favoritas") },
                    selected = currentRoute == "favoritas",
                    onClick = { navController.navigate("favoritas") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Ajustes") },
                    label = { Text("Ajustes") },
                    selected = currentRoute == "ajustes",
                    onClick = { navController.navigate("ajustes") }
                )
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "listado",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("perfil") { ViewPerfil() }


            composable("listado") {
                ViewListado(viewModel = viewModelCompartido)
            }

            composable("favoritas") {
                ViewFavoritas(viewModel = viewModelCompartido)
            }

            composable("ajustes") { ViewConfiguracion() }
        }
    }
}





