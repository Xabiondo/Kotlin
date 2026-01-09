package com.example.proyectokotlin.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ViewConfiguracion() {


    var notificaciones by remember { mutableStateOf(true) }
    var modoOscuro by remember { mutableStateOf(false) }
    var newsletter by remember { mutableStateOf(true) }
    var ubicacion by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Ajustes",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        TituloSeccion(texto = "General")

        ItemInterruptor(
            titulo = "Modo Oscuro",
            subtitulo = "Cambiar la apariencia de la app",
            estado = modoOscuro,
            onCambio = { modoOscuro = it }
        )

        ItemInterruptor(
            titulo = "Ubicación",
            subtitulo = "Permitir acceso al GPS",
            estado = ubicacion,
            onCambio = { ubicacion = it }
        )

        Spacer(modifier = Modifier.height(24.dp))


        TituloSeccion(texto = "Notificaciones")

        ItemInterruptor(
            titulo = "Alertas de empleo",
            subtitulo = "Avísame cuando haya ofertas nuevas",
            estado = notificaciones,
            onCambio = { notificaciones = it }
        )

        ItemInterruptor(
            titulo = "Newsletter",
            subtitulo = "Recibir noticias semanales",
            estado = newsletter,
            onCambio = { newsletter = it }
        )

        Spacer(modifier = Modifier.height(24.dp))


        TituloSeccion(texto = "Cuenta")

        ItemNavegacion(titulo = "Editar Perfil")
        ItemNavegacion(titulo = "Cambiar Contraseña")
        ItemNavegacion(titulo = "Privacidad y Seguridad")

        Spacer(modifier = Modifier.height(24.dp))

        TituloSeccion(texto = "Información")

        ItemNavegacion(titulo = "Términos y Condiciones")
        ItemNavegacion(titulo = "Acerca de la App")

        Spacer(modifier = Modifier.height(32.dp))


        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Versión 1.0.0 (Beta)",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray
            )
        }
    }
}



@Composable
fun TituloSeccion(texto: String) {
    Text(
        text = texto,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
    )
}

@Composable
fun ItemInterruptor(
    titulo: String,
    subtitulo: String,
    estado: Boolean,
    onCambio: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = titulo, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
            Text(text = subtitulo, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
        Switch(
            checked = estado,
            onCheckedChange = onCambio
        )
    }
}

@Composable
fun ItemNavegacion(titulo: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Acción falsa */ }
            .padding(vertical = 12.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = titulo, style = MaterialTheme.typography.bodyLarge)
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray
        )
    }
    Divider(color = Color.LightGray.copy(alpha = 0.3f))
}