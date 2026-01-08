package com.example.proyectokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // IMPORTANTE: Necesario para la lista
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyectokotlin.data.model.Trabajo // Importa tu modelo de datos
import com.example.proyectokotlin.ui.theme.ItemOferta // Importa tu componente visual
import com.example.proyectokotlin.ui.theme.ProyectoKotlinTheme

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
            composable("listado") { ViewListado() }
            composable("favoritas") { ViewFavoritas() }
            composable("ajustes") { ViewConfiguracion() }
        }
    }
}

// --- VISTAS ---

@Composable
fun ViewListado() {
    // 1. Datos falsos de prueba
    val trabajoFake = Trabajo(
        id = 1,
        titulo = "Senior Android Developer",
        empresa = "Google Inc.",
        urlFoto = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/768px-Google_%22G%22_logo.svg.png",
        descripcion = "Estamos buscando un desarrollador experto en Kotlin y Jetpack Compose...",
        salario = "50k - 70k EUR"
    )

    // 2. Lista de verdad
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        // Generamos 10 elementos iguales para probar el scroll
        items(10) {
            ItemOferta(oferta = trabajoFake) { leGusta ->
                println("Like pulsado: $leGusta")
            }
        }
    }
}

@Composable
fun ViewPerfil() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Pantalla de Perfil")
    }
}

@Composable
fun ViewFavoritas() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Pantalla de Favoritas")
    }
}

@Composable
fun ViewConfiguracion() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Pantalla de Configuración")
    }
}