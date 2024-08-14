fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday )}")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday )}")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday )}")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    val basePrice =
    when(age) {
        in 1..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> {
            println("Edad no ingresada correctamente")
            return -1
        }
    }
    return basePrice
}