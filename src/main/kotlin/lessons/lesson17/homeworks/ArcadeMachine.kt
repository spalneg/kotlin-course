package lessons.lesson17.homeworks
//Игровой автомат.
//Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов (аргументы
//и возвращаемые значения), включая модификаторы доступа (private для приватных)
//Поля:
//цвет
//модель
//включен
//ОС загружена
//список установленных игр
//наличие джойстика
//баланс вырученных средств
//владелец
//телефон поддержки
//игровой сеанс оплачен
//стоимость одного игрового сеанса
//пин-код автомата
//Методы:
//включить
//выключить
//загрузить ОС
//завершить работу ОС
//показать список игр
//включить игру
//оплатить игровой сеанс
//забрать наличные с помощью пин-кода
//открыть сейф и выдать наличные

class ArcadeMachine(val color: String,
                    val model: String,
                    val gamepad: Boolean) {
    val owner = ""
    val phoneSupport = ""
    val gamePrice = 10.0
    private var machineIsOn = false
    private var OSLoaded = false
    private val gamesList = emptyList<String>()
    private var balance = 0.0
    private var payed = false
    private var pin: String = "0000"

    private fun turnOn(){
        machineIsOn = true
    }
    private fun turnOff(){
        machineIsOn = false
    }
    private fun loadOS(){
        OSLoaded = true
    }
    private fun turnoffOS(){
        OSLoaded = false
    }
    fun showGames(){
        println("список игр: $gamesList")
    }
    fun startGame(gameName: String){
        if (!payed) println("pay first")
        if (gameName in gamesList) {
            payed = false
            println("Game $gameName is starting!")}
        else println("404")
    }
    fun payGame(){
        balance+= gamePrice
        payed = true
    }
    fun withdraw(pin: String): Double {
        if (pin != this.pin) {
            return 0.0
        }
        return openSafe()
    }
    private fun openSafe(): Double {
        val withdraw = balance
        balance = 0.0
        return withdraw
    }
}