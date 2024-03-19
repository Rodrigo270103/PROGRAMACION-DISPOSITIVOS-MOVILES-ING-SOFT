import kotlin.random.Random

fun main() {
    val numeroAdivinar = Random.nextInt(1, 31) // Generar número aleatorio entre 1 y 30
    var intentos = 5

    println("Bienvenido al juego Adivina el Número!")
    println("Tienes 5 intentos para adivinar un número entre 1 y 30.")


    while (intentos > 0) {
        print("Ingresa tu intento: ")
        val intento = readLine()!!.toInt()

        // Verificar si el intento es correcto
        if (intento == numeroAdivinar) {
            println("¡Felicidades! ¡Adivinaste el número correctamente!")
            return
        } else if (intento < numeroAdivinar) {
            println("El número a adivinar es mayor.")
        } else {
            println("El número a adivinar es menor.")
        }

        intentos--
    }


    println(" Se acabaron los intentos el número era $numeroAdivinar.")
}
