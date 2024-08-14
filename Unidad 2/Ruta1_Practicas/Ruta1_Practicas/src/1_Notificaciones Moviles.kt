fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    println(morningNotification)
    println(eveningNotification)
    printNoficationSummary(morningNotification)
    printNoficationSummary(eveningNotification)
}

fun printNoficationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have $numberOfMessages notification")
    } else {
        numberOfMessages > 100
        println("Your phone is blowing up! You have 99+ notifications")
    }
}