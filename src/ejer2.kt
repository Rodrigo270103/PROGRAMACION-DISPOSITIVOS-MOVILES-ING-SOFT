import kotlin.random.Random

fun main() {
    val opciones = arrayOf("Piedra", "Papel", "Tijera")

    val opcionComputadora = opciones[Random.nextInt(opciones.size)]

    println("Elige una opción: Piedra, Papel o Tijera")
    val opcionUsuario = readLine()

    if (opcionUsuario in opciones) {
        println("Oponente eligió: $opcionComputadora")
        when {
            opcionUsuario == opcionComputadora -> println("Empate")
            (opcionUsuario == "Piedra" && opcionComputadora == "Tijera") ||
                    (opcionUsuario == "Papel" && opcionComputadora == "Piedra") ||
                    (opcionUsuario == "Tijera" && opcionComputadora == "Papel") ->
                println("Ganaste")
            else -> println("Perdiste")
        }
    } else {
        println("Opción inválida")
    }
}
