/**
 * Descripción: Sistema de gestión de biblioteca con clases base y subclases para materiales como libros y revistas, así como clases para usuarios y la biblioteca misma.
 * Autor: Rodrigo Ojeda Arce
 * Fecha de creación: 2024-03-29
 * Fecha de última modificación: 2024-03-29
 */


abstract class Material(
        val titulo: String,
        val autor: String,
        val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}


class Libro(
        titulo: String,
        autor: String,
        anioPublicacion: Int,
        val genero: String,
        val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {
        println("Libro:")
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("Género: $genero")
        println("Número de Páginas: $numeroPaginas")
    }
}


class Revista(
        titulo: String,
        autor: String,
        anioPublicacion: Int,
        val issn: String,
        val volumen: Int,
        val numero: Int,
        val editorial: String
) : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {
        println("Revista:")
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
    }
}


class Usuario(
        val nombre: String,
        val apellido: String,
        val edad: Int
) {
    fun reservarMaterial(material: Material) {
        println("El usuario $nombre $apellido ha reservado el material: ${material.titulo}")
    }

    fun devolverMaterial(material: Material) {
        println("El usuario $nombre $apellido ha devuelto el material: ${material.titulo}")
    }
}


class Biblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosRegistrados = mutableListOf<Usuario>()

    fun agregarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
    }

    fun prestarMaterial(material: Material, usuario: Usuario) {
        if (materialesDisponibles.contains(material)) {
            println("Se ha prestado el material ${material.titulo} al usuario ${usuario.nombre} ${usuario.apellido}")
            materialesDisponibles.remove(material)
        } else {
            println("El material ${material.titulo} no está disponible para préstamo.")
        }
    }

    fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        for (material in materialesDisponibles) {
            material.mostrarDetalles()
            println()
        }
    }
}

fun main() {
    val libro = Libro("El nombre del viento", "Patrick Rothfuss", 2007, "Fantasía", 662)
    val revista = Revista("National Geographic", "Varios", 2023, "1234-5678", 100, 3, "National Geographic Society")
    val usuario = Usuario("Juan", "Perez", 30)
    val biblioteca = Biblioteca()

    biblioteca.agregarMaterial(libro)
    biblioteca.agregarMaterial(revista)
    biblioteca.registrarUsuario(usuario)

    biblioteca.mostrarMaterialesDisponibles()
    println()

    biblioteca.prestarMaterial(libro, usuario)
    biblioteca.mostrarMaterialesDisponibles()
}
