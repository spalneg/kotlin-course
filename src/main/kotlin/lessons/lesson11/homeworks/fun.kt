package lessons.lesson11.homeworks

fun main(){
    println(example1(4, "nevermind"))
    ex2()
    println(ex3(14, 86))
    ex4("Hello, world!")
    println(ex5(listOf(3,7,6,4,9)))
    println(ex6(""))
    println(ex6("count it"))
    println(ex7())
    ex8(listOf(1,2,3))
    println(ex9(1))
    println(ex10())
    println(ex11(null, null))
    println(multiplyByTwo(44))
    println(isEven(4))
    println(isEven(5))
    printNumbersUntil(5)
    printNumbersUntil(0)
    println(findFirstNegative(listOf(1,5,-42,6,-3)))
    println(findFirstNegative(listOf(1,3,5,1)))
    processList(listOf("let's", "print", "it"))
    processList(listOf("stop", "here", null, "don't print"))

}//Задачи на сигнатуру метода
//Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами и возвращаемое значение. В теле метода можешь сделать возврат объекта нужного типа если это требуется для устранения ошибок.
private fun example1(int: Int, str: String): Any{
    return 42
}
//Не принимает аргументов и не возвращает значения.
fun ex2(){
    println("no return!")
}
//Принимает два целых числа и возвращает их сумму.
fun ex3(first: Int, second: Int): Int = first + second
//Принимает строку и ничего не возвращает.
fun ex4(str: String){
    println(str)
}
//Принимает список целых чисел и возвращает среднее значение типа Double.
fun ex5(list: List<Int>): Double{
    val len = list.size
    var result = 0.0
    for (i in list){
        result += i
    }
    result /= len.toDouble()
    return result
}
//Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun ex6(str: String?): Int?{
    return str?.length
}
//Не принимает аргументов и возвращает nullable вещественное число.
fun ex7(): Double?{
    return null
}
//Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun ex8(list: List<Int>?){
    println("it works")
}
//Принимает целое число и возвращает nullable строку.
fun ex9(int: Int): String?{
    return null
}
//Не принимает аргументов и возвращает список nullable строк.
fun ex10(): List<String?>{
    return listOf(null)
}
//Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun ex11(str: String?, int: Int?): Boolean?{
    return null
}
//Задачи на написание кода
//Напишите валидную сигнатуру метода а так же рабочий код для задач.
//Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(int: Int): Int = int * 2

//Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(int: Int): Boolean{
    return int%2 == 0
}
//Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int){
    if (n < 1){
        return
    }
    for (i in 1 .. n){
        println("++$i++")
    }
}
//Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(list: List<Int>): Int?{
    for (i in list){
        if (i < 0){
            return i
        }
    }
    return null
}
//Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(list: List<String?>){
    for (i in list){
        if (i == null){
            return
        }
        else println(i)
    }
}