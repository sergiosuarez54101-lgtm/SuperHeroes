package co.edu.ucaldas.superheroesapp

data class Personaje(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val descripcion: String,
    val superpoderes: List<String>,
    val esHeroe: Boolean // true = Héroe, false = Villano
)

object ListaPersonajes {
    val personajes = listOf(

        Personaje(
            id = 1,
            nombre = "Spider-Man",
            imagenUrl = "https://i.pinimg.com/736x/00/89/5c/00895c5b9d229c02b0ad93f6341f20d1.jpg",
            descripcion = "Peter Parker obtuvo superpoderes tras ser mordido por una araña radiactiva. Protege a Nueva York con gran responsabilidad.",
            superpoderes = listOf("Sentido arácnido", "Fuerza sobrehumana", "Trepar paredes", "Lanza telarañas"),
            esHeroe = true
        ),
        Personaje(
            id = 2,
            nombre = "Batman",
            imagenUrl = "https://i.pinimg.com/236x/49/61/c5/4961c50611721465e9e12e9b0cd00a2f.jpg",
            descripcion = "Bruce Wayne combate el crimen en Ciudad Gótica usando su intelecto, entrenamiento marcial y tecnología avanzada.",
            superpoderes = listOf("Intelecto nivel genio", "Maestro artes marciales", "Gadgets de alta tecnología"),
            esHeroe = true
        ),
        Personaje(
            id = 3,
            nombre = "Iron Man",
            imagenUrl = "https://i.pinimg.com/736x/c2/a0/33/c2a0337b4f31d857df60bcada1f5dd50.jpg",
            descripcion = "Tony Stark es un multimillonario genio e inventor que creó una armadura de alta tecnología para proteger el mundo.",
            superpoderes = listOf("Armadura con repulsores", "Vuelo supersónico", "Mente científica brillante"),
            esHeroe = true
        ),
        Personaje(
            id = 4,
            nombre = "Wonder Woman",
            imagenUrl = "https://i.pinimg.com/736x/cf/f9/e1/cff9e13f814f3c5487bb96575a0c2485.jpg",
            descripcion = "Diana Prince es una princesa amazona de Temiscira bendecida con habilidades de los dioses antiguos.",
            superpoderes = listOf("Fuerza e invulnerabilidad", "Lazo de la Verdad", "Vuelo y gran agilidad"),
            esHeroe = true
        ),

        Personaje(
            id = 5,
            nombre = "Joker",
            imagenUrl = "https://i.pinimg.com/1200x/27/2a/bb/272abb5877ed0279736b0c561b07181c.jpg",
            descripcion = "El criminal más impredecible de Ciudad Gótica. Un maestro del caos obsesionado con Batman.",
            superpoderes = listOf("Mente criminal brillante", "Inmunidad a venenos", "Estratega del caos"),
            esHeroe = false
        ),
        Personaje(
            id = 6,
            nombre = "Thanos",
            imagenUrl = "https://i.pinimg.com/736x/46/16/da/4616da2b9cebe3c7ee76c56d1c03d053.jpg",
            descripcion = "Un poderoso Titán que busca las Gemas del Infinito para restaurar el equilibrio universal a su manera.",
            superpoderes = listOf("Fuerza titánica", "Inviolabilidad física", "Manejo de energía cósmica"),
            esHeroe = false
        ),
        Personaje(
            id = 7,
            nombre = "Green Goblin",
            imagenUrl = "https://i.pinimg.com/736x/1b/8f/83/1b8f839d05d8826422d044e89ab51987.jpg",
            descripcion = "Norman Osborn se transformó en un villano demente tras probar un suero experimental de supersoldado.",
            superpoderes = listOf("Fuerza aumentada", "Planador volador armado", "Bombas de calabaza"),
            esHeroe = false
        ),
        Personaje(
            id = 8,
            nombre = "Venom",
            imagenUrl = "https://i.pinimg.com/736x/c5/f2/d7/c5f2d77dfd4e9f779118ce0d8d99cd8f.jpg",
            descripcion = "Simbionte extraterrestre que se une a un huésped humano para obtener fuerza colosal y habilidades temibles.",
            superpoderes = listOf("Fuerza brutal sobrehumana", "Cambio de forma", "Inmunidad al sentido arácnido"),
            esHeroe = false
        )
    )
}