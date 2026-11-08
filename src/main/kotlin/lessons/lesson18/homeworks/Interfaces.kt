package lessons.lesson18.homeworks

import java.io.InputStream
import kotlin.io.println

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}
//Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
//Холодильник
abstract class Refrigerator(): Powerable, Openable, TemperatureRegulatable, LightEmitting, SoundEmitting
//Стиральная машина
abstract class WashingMachine(): Powerable, Openable, TemperatureRegulatable, SoundEmitting, Timable, Drainable, WaterConnection
//Умная лампа
abstract  class SmartLamp(): Powerable, LightEmitting, Timable, Movable, BatteryOperated
//Электронные часы
abstract class SmartWatch(): Powerable, LightEmitting, BatteryOperated, Rechargeable, Programmable, SoundEmitting
//Робот-пылесос
abstract class RobotVacuumCleaner(): Programmable, Powerable, BatteryOperated, Rechargeable, SoundEmitting, Movable, Cleanable, AutomaticShutdown
//Механические часы
abstract class MechanicWatch(): Mechanical, Movable, Rechargeable, BatteryOperated
//Фонарик
abstract class Flashlight(): Powerable, Movable, Rechargeable, BatteryOperated, LightEmitting
//Кофемашина
abstract class CoffeeMachine(): Powerable, WaterContainer, Cleanable, SoundEmitting
//Умная колонка
abstract class SmartSpeaker(): Powerable, Movable, LightEmitting, SoundEmitting, Programmable, AutomaticShutdown
//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией
//методов (достаточно println с выполняемым действием).
abstract class PowerableEquip(): Powerable{
    protected var powerOn = false
    override fun powerOn() {
        powerOn = true
        println("Power on!")
    }

    override fun powerOff() {
        powerOn = false
        println("Power off!")
    }
}
//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса
// и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.
abstract class ProgrammableEquip(): PowerableEquip(), Programmable {
    override fun programAction(action: String) {
        if (powerOn) println(action)
        else println("first turn it on")
    }
    override fun execute() {
        if (powerOn) println("executing")
        else println("first turn it on")
    }
}
//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться
//с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class Equip(): ProgrammableEquip(), Openable, TemperatureRegulatable{
    override fun open() {
        println("opened")
    }

    override fun close() {
        println("closed")
    }
    override val maxTemperature: Int
        get() = 100

    override fun setTemperature(temp: Int) {
        if (powerOn) println("temperature: $temp")
        else println("first turn it on")
    }
}
//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью
//устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка.
//Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
//Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы)
//не имеет смысла при выключенном питании - добавь эту проверку.
class Fridge(): Equip(), LightEmitting, SoundEmitting{
    override fun emitLight() {
        println("lights on")
    }

    override fun completeLiteEmission() {
        println("light off")
    }

    override fun setVolume(volume: Int) {
        println("sound volume: $volume")
    }

    override fun mute() {
        println("mute")
    }

    override fun playSound(stream: InputStream) {
        println("playing sound")
    }

    override val maxTemperature: Int
        get() = 5

}
class Washing(): Equip(), SoundEmitting, Timable, Drainable, WaterConnection{
    override fun setVolume(volume: Int) {
        println("sound volume: $volume")
    }

    override fun mute() {
        println("mute")
    }

    override fun playSound(stream: InputStream) {
        println("playing sound")
    }

    override fun setTimer(time: Int) {
        println("timeer set: $time")
    }

    override fun connectToDrain() {
        println("connected")
    }

    override fun drain() {
        println("draining")
    }

    override fun connectToWaterSupply() {
        println("connected")
    }

    override fun getWater(amount: Int) {
        println("filling $amount ml of water")
    }

    override val maxTemperature: Int
        get() = 90

}
class Kettle(): Equip(), WaterContainer, AutomaticShutdown{
    override val capacity: Int
        get() = 1000

    override fun fillWater(amount: Int) {
        println("filling $amount of water")
    }

    override fun getWater(amount: Int) {
        println("getting $amount of water")
    }

    override val sensorType: String
        get() = String()
    override val maxSensoredValue: Int
        get() = 1000

    override fun startMonitoring() {
        println("monitoring")
    }

}
class Convection: Equip(), AutomaticShutdown, Timable, SoundEmitting, Cleanable{
    override val maxTemperature: Int
        get() = 300
    override val sensorType: String
        get() = "sensor type"
    override val maxSensoredValue: Int
        get() = 300

    override fun startMonitoring() {
        println("monitoring started")
    }

    override fun setTimer(time: Int) {
        println("timer set on $time")
    }

    override fun setVolume(volume: Int) {
        println("volume set on $volume")
    }

    override fun mute() {
        println("muted")
    }

    override fun playSound(stream: InputStream) {
        println("playing sound")
    }

    override fun clean() {
        println("cleaning")
    }

}
//Создай объекты этих устройств и позапускай их с различными методами.
fun main(){
    val fridge = Fridge()
    val washing = Washing()
    val kettle = Kettle()
    val convection = Convection()
    val devices = listOf(fridge,washing,kettle,convection)
    devices.forEach {
        it.powerOn()
        it.open()
        it.close()
        it.programAction("programming")
        it.execute()
        it.powerOff()
    }
    fridge.setTemperature(2)
}