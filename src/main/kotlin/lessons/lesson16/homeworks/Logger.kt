package lessons.lesson16.homeworks
//Класс “Логгер”: представляет собой инструмент для вывода информации в консоль с разным префиксами уровня логирования
//(INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO.
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO.
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR.
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.

class Logger {
    fun log(message: String){
        println("INFO: $message")
    }
    fun log(lvl: String, message: String){
        if(lvl == "WARNING"){
            println("${Colors.YELLOW}$lvl: $message${Colors.RESET}")}
        else if(lvl == "ERROR"){
            println("${Colors.WHITE}${Background.RED}$lvl: $message${Colors.RESET}")}
        else println("$lvl $message")
    }
    fun log(list: List<String>){
        list.forEach {
            println("INFO: $it")
        }
    }
    fun log(exception: Exception){
        println("${Colors.WHITE}${Background.RED}ERROR: ${exception.message}${Colors.RESET}")
    }
}
fun main(){
    val logger = Logger()
    logger.log("напечатай инфо")
    logger.log("WARNING","ворнинг напечатай жёлтым")
    logger.log("ERROR","еррор напечатай белым на красном")
    logger.log("ELSE","обычный текст")
    logger.log(listOf("тут инфо","и тут","и снова"))
    logger.log(Exception("Что-то пошло не так в программе!"))
}
