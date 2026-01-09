package com.example.proyectokotlin.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectokotlin.ui.theme.ItemOferta
import com.example.proyectokotlin.viewmodel.TrabajoViewModel

@Composable
fun ViewFavoritas(viewModel: TrabajoViewModel = viewModel()) {


    LaunchedEffect(Unit) {
        viewModel.cargarFavoritos()
    }


    val favoritos = viewModel.listaFavoritos

    Box(modifier = Modifier.fillMaxSize()) {


        if (favoritos.isEmpty()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Aún no tienes favoritos guardados",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }

        else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(favoritos) { oferta ->


                    ItemOferta(
                        oferta = oferta,
                        isFavorito = true,
                        onLikeClick = {

                            viewModel.eliminarDeFavoritos(oferta)
                        }
                    )
                }
            }
        }
    }
}