/**
 * Descripción: Clase abstracta "Shape" con propiedades y métodos para calcular área y perímetro.
 * Autor: Rodrigo Ojeda Arce
 * Fecha de creación: 2024-03-29
 * Fecha de última modificación: 2024-03-29
 */

import kotlin.math.PI

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(val lado: Double) : Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

class Circulo(val radio: Double) : Shape() {
    override fun calcularArea(): Double {
        return PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * PI * radio
    }
}

class Rectangulo(val base: Double, val altura: Double) : Shape() {
    override fun calcularArea(): Double {
        return base * altura
    }

    override fun calcularPerimetro(): Double {
        return 2 * (base + altura)
    }
}

fun main() {
    val cuadrado = Cuadrado(5.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(4.0, 6.0)

    println("Cuadrado:")
    cuadrado.imprimirResultados()
    println()

    println("Círculo:")
    circulo.imprimirResultados()
    println()

    println("Rectángulo:")
    rectangulo.imprimirResultados()
}
