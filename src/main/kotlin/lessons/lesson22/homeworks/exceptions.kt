package lessons.lesson22.homeworks

fun main() {
//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
//NullPointerException
    try {
        val num: Int? = null
        println(num as Int)
    } catch (e: NullPointerException) {
        println("Обработано исключение $e")
    }

//IndexOutOfBoundsException
    try {
        val exList = listOf(2, 3, 1, 6)
        println(exList[4])
    } catch (e: IndexOutOfBoundsException) {
        println("Обработано исключение $e")
    }

//ClassCastException
    try {
        val cast: List<String> = listOf("a", "b", "c")
        println(cast as Int)
    } catch (e: ClassCastException) {
        println("Обработано исключение $e")
    }

//IllegalArgumentException
    try {
        setTime(25)
    } catch (e: IllegalArgumentException) {
        println("Обработано исключение $e")
    }

//NumberFormatException
    try {
        val number = "45n"
        println(number.toInt())
    } catch (e: NumberFormatException) {
        println("Обработано исключение $e")
    }

//IllegalStateException
    try {
        checkState(false)
    } catch (e: IllegalStateException) {
        println("Обработано исключение $e")
    }

//OutOfMemoryError
    try {
        generateLargeList()
    } catch (e: OutOfMemoryError) {
        println("Обработано исключение $e")
    }

//StackOverflowError
    try {
        recursiveFunction()
    } catch (e: StackOverflowError) {
        println("Обработано исключение $e")
    }
}
//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий
//с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи
//сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw, чтобы прекратить
//работу программы. Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный аргумент
//фантастически хорош!
fun exceptionTests(arg: Any?){
    try {
        arg!!
        arg as List<*>
        arg[6]
        require(arg[6] is String)
        check((arg[6] as String).toInt() == 9)
    } catch (e: Throwable) {
    val result = when (e) {
        is NullPointerException -> "It is NullPointerException"
        is ClassCastException -> "It is ClassCastException"
        is IndexOutOfBoundsException -> "It is IndexOutOfBoundsException"
        is NumberFormatException -> "It is NumberFormatException"
        is IllegalArgumentException -> "It is IllegalArgumentException"
        is IllegalStateException -> "It is IllegalStateException"
        else -> "It is unknown exception"
    }
    println(result)
    throw e
}
    println("We have a fantastically good argument!")
}
fun setTime(age: Int) {
    require( age <= 24) { "в сутках 24 часа" }
}

fun checkState(state: Boolean) {
    check(state) { "No" }
}

fun generateLargeList() {
    val largeList = mutableListOf<Int>()
    while (true) {
        largeList.add(1) // Бесконечно добавляем элементы в список
    }
}

fun recursiveFunction() {
    recursiveFunction()
}

