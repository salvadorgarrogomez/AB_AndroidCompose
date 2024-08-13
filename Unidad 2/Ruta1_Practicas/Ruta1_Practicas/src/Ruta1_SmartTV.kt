import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice (val name: String, val category: String) {
    //private var deviceStatus = "online"

    open val deviceType = "unknown"

    var deviceStatus = "online"
        protected set

    open fun turnOn() {
        deviceStatus = "on"
    }
    open fun turnOff(){
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, deviceType: $deviceType")
    }
}

open class SmartTvDevice (deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    /*
    private var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    private var channelNumber = 1
        set(value) {
            if (value in 0..200){
                field = value
            }
        }

     */

    fun increaseSpeakerVolme() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }
    override fun turnOn() {
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber")
    }
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }
    fun previousChannel() {
        channelNumber--
        println("$name previous channel number increased to $channelNumber")
    }
    fun printTvDeviceInfo() {
        println("Device name: $name, category: $category, deviceType: $deviceType")
    }
}

class SmartLightDevice (deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    /*
    private var brightnessLevel = 0
        set (value) {
            if (value in 0..100) {
                field = value
            }
        }

     */

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }
    fun decreaseBrightness() {
        brightnessLevel--
        println("$name brightness level decreased to $brightnessLevel")
    }

    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel")
    }
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
    fun printLightDeviceInfo() {
        println("Device name: $name, category: $category, deviceType: $deviceType")
    }
}

class SmartHome (
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice,
    val smartDevice: SmartDevice
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if(smartDevice.deviceStatus == "on"){
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
    }
    fun turnOffTv() {
        if(smartDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }
    fun increaseTvVolume() {
        if(smartDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolme()
        }
    }
    fun decreaseTvVolume() {
        if(smartDevice.deviceStatus == "on") {
            smartTvDevice.decreaseVolume()
        }
    }
    fun changeTvChannelToNext() {
        if(smartDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        }
    }
    fun changeTvChannelToPrevious() {
        if(smartDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        }
    }
    fun turnOnLight() {
        if(smartDevice.deviceStatus == "on") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }
    fun turnOffLight() {
        if(smartDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }
    fun increaseLightBrightness() {
        if(smartDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }
    }
    fun decreaseLightBrightness() {
        if(smartDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        }
    }
    fun turnOffAllDevices() {
        if(smartDevice.deviceStatus == "on") {
            turnOffLight()
            turnOffTv()
        }
    }
    fun printSmartTvInfo() {
        if(smartDevice.deviceStatus == "on") {
            smartTvDevice.printTvDeviceInfo()
        }
    }
    fun printSmartLightInfo() {
        if(smartDevice.deviceStatus == "on") {
            smartLightDevice.printLightDeviceInfo()
        }
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int,
) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value <= maxValue) {
            fieldData = value
        }
    }
}

fun main() {

    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()

    var smartHome = SmartHome(SmartTvDevice("Android TV", "Entertainment"),
        SmartLightDevice("Google Light", "Utility"),
        smartDevice)
    smartHome.turnOffTv()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    smartHome.changeTvChannelToNext()
    smartHome.decreaseTvVolume()
    smartHome.printSmartLightInfo()
}