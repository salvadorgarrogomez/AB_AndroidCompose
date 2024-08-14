fun main() {
    val celsiusToFahrenheit: (Double) -> Double = { celsius -> (celsius * 9 / 5) + 32 }
    val celsiusToKelvin: (Double) -> Double = { celsius -> celsius + 273.15 }
    val fahrenheitToCelsius: (Double) -> Double = { fahrenheit -> (fahrenheit - 32) * 5 / 9 }
    val fahrenheitToKelvin: (Double) -> Double = { fahrenheit -> (fahrenheit - 32) * 5 / 9 + 273.15 }
    val kelvinToCelsius: (Double) -> Double = { kelvin -> kelvin - 273.15 }
    val kelvinToFahrenheit: (Double) -> Double = { kelvin -> (kelvin - 273.15) * 9 / 5 + 32 }


    printFinalTemperature(27.0, "Celsius", "Fahrenheit", celsiusToFahrenheit)
    printFinalTemperature(27.0, "Celsius", "Kelvin", celsiusToKelvin)
    printFinalTemperature(27.0, "Fahrenheit", "Celsius", fahrenheitToCelsius)
    printFinalTemperature(27.0, "Fahrenheit", "Kelvin", fahrenheitToKelvin)
    printFinalTemperature(27.0, "Kelvin", "Celsius", kelvinToCelsius)
    printFinalTemperature(27.0, "Kelvin", "Fahrenheit", kelvinToFahrenheit)
}

fun printFinalTemperature(
    initialMeasurment: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double,
) {
    val finalMeasurment = String.format("%.2f", conversionFormula(initialMeasurment))
    println("$initialMeasurment degrees $initialUnit is $finalMeasurment degrees $finalUnit")
}