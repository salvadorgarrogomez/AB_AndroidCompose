open class Phone(var isScreenLightOn: Boolean = false) {

    open fun switchOn() {
        isScreenLightOn = true
    }
    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight(){
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight")
    }
}

class FoldablePhone(var isPlegable: Boolean = true) : Phone() {

    override fun switchOn() {
        if (!isPlegable) {
            isScreenLightOn = true
        }
    }

    fun switchPlegableOn() {
        isPlegable = true
    }
    fun switchPlegableOff() {
        isPlegable = false
    }
}

fun main() {
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.switchPlegableOff()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}