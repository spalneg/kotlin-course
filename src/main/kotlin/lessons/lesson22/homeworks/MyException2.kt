package lessons.lesson22.homeworks

//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
//IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
//перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.

class MyException2(cause: IndexOutOfBoundsException) : RuntimeException(cause)

fun main() {
    try {
        listOf("")[1]
    } catch (e: IndexOutOfBoundsException) {
        println("Произошёл IndexOutOfBoundsException")
        throw MyException2(e)
    }
}