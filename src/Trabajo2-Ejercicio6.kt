/**
 * Descripción: Sistema de alquiler de vehículos con interfaces y clases concretas para coches y motos.
 * Autor: Rodrigo Ojeda Arce
 * Fecha de creación: 2024-03-29
 * Fecha de última modificación: 2024-03-29
 */


interface VehiculoAlquilable {
    fun alquilar()
    fun devolver()
}


class Coche(val modelo: String) : VehiculoAlquilable {
    var alquilado: Boolean = false

    override fun alquilar() {
        if (alquilado) {
            alquilado = true
            println("Coche modelo $modelo alquilado.")
        } else {
            println("El coche modelo $modelo ya está alquilado.")
        }
    }

    override fun devolver() {
        if (alquilado) {
            alquilado = false
            println("Coche modelo $modelo devuelto.")
        } else {
            println("El coche modelo $modelo no estaba alquilado.")
        }
    }
}


class Moto(val marca: String) : VehiculoAlquilable {
    var alquilado: Boolean = false

    override fun alquilar() {
        if (alquilado) {
            alquilado = true
            println("Moto marca $marca alquilada.")
        } else {
            println("La moto marca $marca ya está alquilada.")
        }
    }

    override fun devolver() {
        if (alquilado) {
            alquilado = false
            println("Moto marca $marca devuelta.")
        } else {
            println("La moto marca $marca no estaba alquilada.")
        }
    }
}

fun main() {
    val coche = Coche("Toyota")
    val moto = Moto("Honda")

    coche.alquilar() // Coche modelo Toyota alquilado.
    moto.alquilar() // Moto marca Honda alquilada.

    coche.devolver() // Coche modelo Toyota devuelto.
    moto.devolver() // Moto marca Honda devuelta.

    coche.alquilar() // Coche modelo Toyota alquilado.
    coche.alquilar() // El coche modelo Toyota ya está alquilado.
}
