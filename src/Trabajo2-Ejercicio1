/**
 * Descripción: Clase para representar una cuenta bancaria con saldo y límite de retiro.
 * Autor: Rodrigo Ojeda Arce
 * Fecha de creación: 2024-03-26
 * Fecha de última modificación: 2024-03-29
 */

class CuentaBancaria(private var saldo: Double, private val limiteRetiro: Double) {

    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(nuevoSaldo: Double) {
        saldo = nuevoSaldo
    }

    fun realizarRetiro(monto: Double): Boolean {
        if (monto > limiteRetiro || monto > saldo) {
            println("No se puede realizar el retiro. El monto excede el límite de retiro o el saldo disponible.")
            return false
        } else {
            saldo -= monto
            println("Retiro exitoso de $monto. Saldo actual: $saldo")
            return true
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)

    cuenta.realizarRetiro(300.0)
    cuenta.realizarRetiro(800.0)
}
