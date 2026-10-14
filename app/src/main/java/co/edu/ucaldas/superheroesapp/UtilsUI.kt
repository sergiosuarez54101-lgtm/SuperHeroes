package co.edu.ucaldas.superheroesapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ImagenPersonaje(
    url: String,
    descripcion: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = url,
        contentDescription = descripcion,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
    )
}

@Composable
fun TarjetaPersonaje(
    personaje: Personaje,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImagenPersonaje(
                url = personaje.imagenUrl,
                descripcion = personaje.nombre,
                modifier = Modifier.size(80.dp) // Tamaño de la imagen en la lista
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = personaje.nombre,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (personaje.esHeroe) "Superhéroe" else "Supervillano",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}