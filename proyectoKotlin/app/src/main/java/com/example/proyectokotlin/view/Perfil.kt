package com.example.proyectokotlin.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ViewPerfil() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            AsyncImage(
                model = "https://i.pravatar.cc/300?img=11",
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            SmallFloatingActionButton(
                onClick = { },
                modifier = Modifier.size(35.dp),
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Edit, contentDescription = null, tint = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Xabier García",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Desarrollador Android Junior",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                FilaContacto(icon = Icons.Default.Email, texto = "xgarciaber@educacion.navarra.es")
                Spacer(modifier = Modifier.height(8.dp))
                FilaContacto(icon = Icons.Default.Phone, texto = "+34 600 123 456")
                Spacer(modifier = Modifier.height(8.dp))
                FilaContacto(icon = Icons.Default.LocationOn, texto = "Pamplona, Navarra")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Sobre mí",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Start),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Apasionado por la tecnología y el desarrollo móvil. Actualmente aprendiendo Jetpack Compose y Clean Architecture. Busco mi primera oportunidad laboral para demostrar mis habilidades.",
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Habilidades",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Start),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SuggestionChip(onClick = {}, label = { Text("Kotlin") })
            SuggestionChip(onClick = {}, label = { Text("Compose") })
            SuggestionChip(onClick = {}, label = { Text("Room") })
            SuggestionChip(onClick = {}, label = { Text("Git") })
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Experiencia",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Start),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        ItemExperiencia(
            puesto = "Prácticas Desarrollo Apps",
            empresa = "Tech Navarra S.L.",
            fecha = "Ene 2023 - Jun 2023"
        )
        ItemExperiencia(
            puesto = "Soporte Técnico",
            empresa = "Informática del Norte",
            fecha = "2021 - 2022"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cerrar Sesión")
        }
    }
}

@Composable
fun FilaContacto(icon: ImageVector, texto: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = texto, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ItemExperiencia(puesto: String, empresa: String, fecha: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = puesto, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = empresa, style = MaterialTheme.typography.bodyMedium)
            Text(text = fecha, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
        }
    }
}