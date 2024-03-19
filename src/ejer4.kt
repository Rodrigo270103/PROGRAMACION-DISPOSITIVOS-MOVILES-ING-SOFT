fun main() {
    var opcion: Int
    do {

        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Seleccione una opción: ")


        opcion = readLine()!!.toInt()


        when (opcion) {
            1 -> sumar()
            2 -> restar()
            3 -> multiplicar()
            4 -> dividir()
            5 -> println("programa termindao")
            else -> println("Opción inválida")
        }
    } while (opcion != 5)
}

fun sumar() {
    val num1 = solicitarNumero("Ingrese el primer número: ")
    val num2 = solicitarNumero("Ingrese el segundo número: ")
    println("La suma de $num1 y $num2 es: ${num1 + num2}")
}

fun restar() {
    val num1 = solicitarNumero("Ingrese el primer número: ")
    val num2 = solicitarNumero("Ingrese el segundo número: ")
    println("La resta de $num1 y $num2 es: ${num1 - num2}")
}

fun multiplicar() {
    val num1 = solicitarNumero("Ingrese el primer número: ")
    val num2 = solicitarNumero("Ingrese el segundo número: ")
    println("La multiplicación de $num1 y $num2 es: ${num1 * num2}")
}

fun dividir() {
    val num1 = solicitarNumero("Ingrese el dividendo: ")
    val num2 = solicitarNumero("Ingrese el divisor: ")
    if (num2 != 0) {
        println("La división de $num1 y $num2 es: ${num1.toDouble() / num2}")
    } else {
        println("No se puede dividir por cero.")
    }
}

fun solicitarNumero(mensaje: String): Int {
    print(mensaje)
    return readLine()!!.toInt()
}
