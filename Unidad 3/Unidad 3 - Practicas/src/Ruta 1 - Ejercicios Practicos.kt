data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

enum class Daypart{
    MORNING, AFTERNOON, EVENING
}

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    println(Event("Estudiar Kotlin", "Compormeterse a estudiar Kotlin al menos 15 minutos al dia", Daypart.EVENING,15))

    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    val events = mutableListOf(event1, event2, event3, event4, event5, event6)

    val cortos = events.filter {
        it.durationInMinutes < 60
    }
    println("Tienes ${cortos.size} eventos cortos")

    // Con estas dos formas, filter() y groupBy() se consigue lo mismo, ambas formas son validas, pero es preferible la opcion gruopBy(), mas concisa.
    /*
    val mañana = events.filter { it.daypart == Daypart.MORNING }
    val tarde = events.filter { it.daypart == Daypart.AFTERNOON }
    val noche = events.filter { it.daypart == Daypart.EVENING }
    println("Morning: ${mañana.size} eventos")
    println("Afternoon: ${tarde.size} eventos")
    println("Evening: ${noche.size} eventos")
     */

    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach {
        (daypart, events) ->
        println("$daypart: ${events.size} eventos")
    }

    println("El ultimo evento del dia es el siguiente: ${events.last().title}")
    println("La duracion del primer evento del dia: ${events[0].durationOfEvent}")

    for (event in events) {
        println(event)
    }
}