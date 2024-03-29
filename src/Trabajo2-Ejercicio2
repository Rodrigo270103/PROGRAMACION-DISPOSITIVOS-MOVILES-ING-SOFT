/**
 * Descripción: Clase para representar un producto con precio y descuento aplicable.
 * Autor: Rodrigo Ojeda Arce
 * Fecha de creación: 2024-03-26
 * Fecha de última modificación: 2024-03-29
 */

class Producto(private var precio: Double, private var descuento: Double) {

    fun getPrecio(): Double {
        return precio
    }

    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("El precio no puede ser negativo.")
        }
    }

    fun getDescuento(): Double {
        return descuento
    }

    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento >= 0 && nuevoDescuento <= 100) {
            descuento = nuevoDescuento
        } else {
            println("El descuento debe estar en el rango de 0 a 100.")
        }
    }

    fun calcularPrecioFinal(): Double {
        val precioConDescuento = precio * (1 - descuento / 100)
        return precioConDescuento
    }
}

fun main() {
    val producto = Producto(100.0, 10.0)

    println("Precio original: ${producto.getPrecio()}")
    println("Descuento aplicado: ${producto.getDescuento()}%")
    println("Precio final después de aplicar el descuento: ${producto.calcularPrecioFinal()}")

    producto.setPrecio(-50.0)
    producto.setDescuento(120.0)
}
