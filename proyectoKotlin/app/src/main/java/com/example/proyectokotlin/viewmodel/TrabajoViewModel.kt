package com.example.proyectokotlin.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope

import com.example.proyectokotlin.model.RetrofitClient
import com.example.proyectokotlin.model.Trabajo
import com.example.proyectokotlin.model.TrabajoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TrabajoViewModel(application: Application) : AndroidViewModel(application) {

    var listaOfertas by mutableStateOf<List<Trabajo>>(emptyList())
        private set

    var listaFavoritos by mutableStateOf<List<Trabajo>>(emptyList())
        private set

    var estaCargando by mutableStateOf(false)

    private val dao = TrabajoDatabase.getDatabase(application).trabajoDao()

    init {
        cargarOfertas()
        cargarFavoritos()
    }

    fun cargarOfertas() {
        viewModelScope.launch {
            estaCargando = true
            try {
                val respuesta = RetrofitClient.instance.obtenerOfertas(pais = "spain", cantidad = 50)
                listaOfertas = respuesta.trabajos
            } catch (e: Exception) {
                println("Error conectando: ${e.message}")
            } finally {
                estaCargando = false
            }
        }
    }

    fun gestionarLike(trabajo: Trabajo, esLike: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (esLike) {
                dao.guardarFavorito(trabajo)
            } else {
                dao.borrarFavorito(trabajo)
            }
            cargarFavoritos()
        }
    }

    fun cargarFavoritos() {
        viewModelScope.launch(Dispatchers.IO) {
            listaFavoritos = dao.obtenerFavoritos()
        }
    }

    fun eliminarDeFavoritos(trabajo: Trabajo) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.borrarFavorito(trabajo)
            cargarFavoritos()
        }
    }
}