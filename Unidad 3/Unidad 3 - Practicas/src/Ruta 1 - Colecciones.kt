fun main() {
    /*
    val rockPlanets = arrayOf("Mercury","Venus","Earth","Mars")
    val gasPlanets = arrayOf("Jupiter","Saturn","Uranus","Neptune")
    val solarSystem = rockPlanets + gasPlanets
    println(solarSystem[2])
    println(solarSystem[3])
    solarSystem[3] = "Little Earth"
    println(solarSystem[3])

    val newSystemPlanets = mutableListOf("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto")
    println(newSystemPlanets.size)
    println(newSystemPlanets.get(3))
    println(newSystemPlanets.indexOf("Pluto"))

    // Dos formas de hacer lo mismo, pero uno en base al String y otro en base a la posicion
    newSystemPlanets.removeAt(8)
    newSystemPlanets.remove("Pluto")

    newSystemPlanets.add(3, "Theia")
    newSystemPlanets[3] = "Future Moon"
    println(newSystemPlanets.contains("Mars"))

    newSystemPlanets.remove("Future Moon")
    println("Future Moon" in newSystemPlanets)

    val newSystemPlanets = mutableSetOf("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune")
    println(newSystemPlanets.size)
    newSystemPlanets.add("Pluto")
    println(newSystemPlanets.size)
    println(newSystemPlanets.contains("Pluto"))

     */

    val newSystemPlanets = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(newSystemPlanets.size)
    newSystemPlanets["Pluto"] = 5
    println(newSystemPlanets.size)
    println(newSystemPlanets["Pluto"])
    println(newSystemPlanets.get("Theia"))
    newSystemPlanets["Earth"] = 5

    for (planet in newSystemPlanets) {
        println(planet)
    }
}

