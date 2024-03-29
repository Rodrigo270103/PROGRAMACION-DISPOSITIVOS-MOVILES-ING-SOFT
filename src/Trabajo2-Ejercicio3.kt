/**
 * Descripción: Sistema de gestión de empleados con clases base y subclases para empleados a tiempo completo y medio tiempo.
 * Autor: Rodrigo Ojeda
 * Fecha de creación: 2024-03-29
 * Fecha de última modificación: 2024-03-29
 */

abstract class Empleado(
        val nombre: String,
        val apellido: String,
        val edad: Int,
        var salario: Double
) {
    abstract fun calcularPago(): Double
}

class EmpleadoTiempoCompleto(
        nombre: String,
        apellido: String,
        edad: Int,
        salario: Double,
        val horasTrabajadas: Int,
        val tarifaHora: Double
) : Empleado(nombre, apellido, edad, salario) {

    override fun calcularPago(): Double {
        return horasTrabajadas * tarifaHora
    }
}

class EmpleadoMedioTiempo(
        nombre: String,
        apellido: String,
        edad: Int,
        salario: Double,
        val horasTrabajadas: Int,
        val tarifaHora: Double,
        val diasTrabajados: Int
) : Empleado(nombre, apellido, edad, salario) {

    override fun calcularPago(): Double {
        return horasTrabajadas * tarifaHora * diasTrabajados
    }
}

fun main() {
    val empleadoTiempoCompleto = EmpleadoTiempoCompleto("Juan", "Perez", 30, 0.0, 40, 15.0)
    val empleadoMedioTiempo = EmpleadoMedioTiempo("Maria", "Gomez", 25, 0.0, 20, 12.0, 5)

    println("Pago de ${empleadoTiempoCompleto.nombre} ${empleadoTiempoCompleto.apellido}: ${empleadoTiempoCompleto.calcularPago()}")
    println("Pago de ${empleadoMedioTiempo.nombre} ${empleadoMedioTiempo.apellido}: ${empleadoMedioTiempo.calcularPago()}")
}
