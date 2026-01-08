package com.example.proyectokotlin.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectokotlin.data.model.Trabajo

import com.example.proyectokotlin.model.RetrofitClient
import kotlinx.coroutines.launch

class TrabajoViewModel : ViewModel() {


    var listaOfertas by mutableStateOf<List<Trabajo>>(emptyList())
        private set // Solo modificable desde dentro

    // 2. Estado de carga (opcional, para mostrar una ruedita)
    var estaCargando by mutableStateOf(false)

    // 3. Al iniciar, llamamos a la API automáticamente
    init {
        cargarOfertas()
    }

    fun cargarOfertas() {
        viewModelScope.launch {
            estaCargando = true
            try {
                // Llamamos a la API en segundo plano
                val respuesta = RetrofitClient.instance.obtenerOfertas(pais = "spain", cantidad = 20)

                // Jobicy devuelve un objeto con una lista dentro llamada "jobs"
                // Si la respuesta es null, ponemos lista vacía
                listaOfertas = respuesta.trabajos

            } catch (e: Exception) {
                println("Error conectando: ${e.message}")
            } finally {
                estaCargando = false
            }
        }
    }
}