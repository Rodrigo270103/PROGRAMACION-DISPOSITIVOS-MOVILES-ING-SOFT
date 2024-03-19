fun main() {

    print("Ingrese el número de alumnos en el salón: ")
    val cantidadAlumnos = readLine()!!.toInt()

    var edadMaxima = Int.MIN_VALUE
    var edadMinima = Int.MAX_VALUE

    println("Ingrese la edad de cada alumno:")
    for (i in 1..cantidadAlumnos) {
        print("Alumno $i: ")
        val edad = readLine()!!.toInt()

        if (edad > edadMaxima) {
            edadMaxima = edad
        }

        if (edad < edadMinima) {
            edadMinima = edad
        }
    }

    println("=== Edades ===")
    println("Máximo = $edadMaxima")
    println("Mínimo = $edadMinima")
    print("Todos = ")
    for (i in 1 until cantidadAlumnos) {
        print("$i, ")
    }
    println(cantidadAlumnos)
}
