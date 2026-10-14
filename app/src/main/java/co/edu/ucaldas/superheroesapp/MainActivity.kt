package co.edu.ucaldas.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.edu.ucaldas.superheroesapp.ui.theme.SuperHeroesAppTheme // Reemplaza tiene otro nombre

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesAppTheme {
                AppNavigation()
            }
        }
    }
}

// 1. navegacion

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        //Pantalla de Inicio
        composable("inicio") {
            PantallaInicio(
                onCategoriaSeleccionada = { esHeroe ->
                    navController.navigate("lista/$esHeroe")
                }
            )
        }

        //Pantalla de Lista (Recibe si filtró héroes o villanos)
        composable(
            route = "lista/{esHeroe}",
            arguments = listOf(navArgument("esHeroe") { type = NavType.BoolType })
        ) { backStackEntry ->
            val esHeroe = backStackEntry.arguments?.getBoolean("esHeroe") ?: true
            PantallaLista(
                esHeroe = esHeroe,
                onPersonajeSeleccionado = { personajeId ->
                    navController.navigate("detalle/$personajeId")
                },
                onVolver = { navController.popBackStack() }
            )
        }

        //Pantalla de Detalle (Recibe el ID del personaje)
        composable(
            route = "detalle/{personajeId}",
            arguments = listOf(navArgument("personajeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val personajeId = backStackEntry.arguments?.getInt("personajeId") ?: -1
            val personaje = ListaPersonajes.personajes.find { it.id == personajeId }

            if (personaje != null) {
                PantallaDetalle(
                    personaje = personaje,
                    onVolver = { navController.popBackStack() }
                )
            }
        }
    }
}

// 2. PANTALLA DE INICIO (Menú Principal)

@Composable
fun PantallaInicio(onCategoriaSeleccionada: (Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Universo de Personajes",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Tarjeta para la seccion de Superhéroes
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable { onCategoriaSeleccionada(true) },
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Superhéroes 🦸‍♂️", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta para la seccion de Supervillanos
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable { onCategoriaSeleccionada(false) },
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Supervillanos 🦹‍♂️", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// 3. PANTALLA DE LISTA (LazyColumn Filtrada)

@Composable
fun PantallaLista(
    esHeroe: Boolean,
    onPersonajeSeleccionado: (Int) -> Unit,
    onVolver: () -> Unit
) {
    val personajesFiltrados = ListaPersonajes.personajes.filter { it.esHeroe == esHeroe }
    val titulo = if (esHeroe) "Superhéroes" else "Supervillanos"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onVolver, modifier = Modifier.padding(bottom = 8.dp)) {
            Text("← Volver")
        }

        Text(
            text = titulo,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        LazyColumn {
            items(personajesFiltrados) { personaje ->
                TarjetaPersonaje(
                    personaje = personaje,
                    onClick = { onPersonajeSeleccionado(personaje.id) }
                )
            }
        }
    }
}

// 4. PANTALLA DE DETALLE (Ficha Técnica)

@Composable
fun PantallaDetalle(
    personaje: Personaje,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onVolver, modifier = Modifier.padding(bottom = 16.dp)) {
            Text("← Volver")
        }

        ImagenPersonaje(
            url = personaje.imagenUrl,
            descripcion = personaje.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = personaje.nombre,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = personaje.descripcion,
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Superpoderes:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        personaje.superpoderes.forEach { poder ->
            Text(
                text = "• $poder",
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}