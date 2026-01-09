package com.example.proyectokotlin.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectokotlin.ui.theme.ItemOferta
import com.example.proyectokotlin.viewmodel.TrabajoViewModel

@Composable
fun ViewListado(viewModel: TrabajoViewModel = viewModel()) {


    LaunchedEffect(Unit) {
        viewModel.cargarFavoritos()
    }

    val ofertas = viewModel.listaOfertas
    val cargando = viewModel.estaCargando
    val favoritosIds = viewModel.listaFavoritos.map { it.id }.toSet()

    Box(modifier = Modifier.fillMaxSize()) {

        if (cargando) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(ofertas) { oferta ->
                    val esFavorito = favoritosIds.contains(oferta.id)
                    ItemOferta(
                        oferta = oferta,
                        isFavorito = esFavorito,
                        onLikeClick = {
                            viewModel.gestionarLike(oferta, !esFavorito)
                        }
                    )
                }
            }
        }
    }
}