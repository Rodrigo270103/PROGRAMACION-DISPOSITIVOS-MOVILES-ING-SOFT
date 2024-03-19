fun main() {

    print("Ingrese puntuación : ")
    val puntuacion = readLine()!!.toDouble()

    print("Ingrese salario mensual: ")
    val salarioMensual = readLine()!!.toDouble()

    val nivelRendimiento = determinarNivelRendimiento(puntuacion)

    val cantidadDinero = calcularCantidadDinero(puntuacion, salarioMensual)


    println("Nivel de Rendimiento: $nivelRendimiento")
    println(" Dinero Recibido: \$$cantidadDinero")
}

fun determinarNivelRendimiento(puntuacion: Double): String {
    return when {
        puntuacion >= 0 && puntuacion <= 3 -> "Inaceptable"
        puntuacion >= 4 && puntuacion <= 6 -> "Aceptable"
        puntuacion >= 7 && puntuacion <= 10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularCantidadDinero(puntuacion: Double, salarioMensual: Double): Double {
    return salarioMensual * (puntuacion / 10)
}
