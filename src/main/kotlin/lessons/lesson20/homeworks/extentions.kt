package lessons.lesson20.homeworks

import kotlin.math.absoluteValue

//Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел -
//первое и последнее. Если массив был пуст, то вернуть пару из null значений.
fun Array<Int>.returnPair(): Pair<Int?, Int?>{
    if (this.isEmpty()){
        return (null to null)
    }
    else return (this[0] to this.last())
}
//Создайте функцию-расширение для изменяемого списка элементов:
//с дженериком T ограниченным интерфейсом Comparable<T>
//которая принимает булево значение,
//возвращает этот же список только в виде неизменяемого
//сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true и по
//убыванию, если false (используем функции sort() и sortDescending()
fun <T : Comparable<T>> MutableList<T>.modifiedList(arg: Boolean): List<T> {
    if (arg) sort() else sortDescending()
    return this
}
//Создайте функцию-расширение для nullable словаря с дженериком:
//Ключ является дженериком,
//Значение является списком из дженериков.
//Принимает целое число.
//Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
//Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса
//нет - значением будет null.
fun <T> Map<T, List<T>>?.modifiedMap(arg: Int): Map<String, T?>?{
    if (this == null){
        return null
    }
    return this
        .mapKeys { it.key.toString() }
        .mapValues { it.value.getOrNull(arg) }
}
//Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного
//не более допустимого значения. Метод принимает два параметра: other — число для сравнения и deviation — максимально
//допустимое отклонение. Метод должен возвращать true, если разница между текущим числом и числом для сравнения
//не превышает заданное отклонение. Протестируйте функцию на разных типах чисел. Для получения отклонения, у разницы
//чисел нужно вызвать свойство absoluteValue.
fun Number.within(other: Number, deviation: Number): Boolean{
    return ((this.toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble())
}
//Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый символ
//исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад.
//Оба метода принимают один параметр base типа Int, который определяет величину сдвига. Протестируйте вашу реализацию,
//убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
//Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.
fun String.encrypt(base: Int): String = this.map { it + base }.joinToString("")
fun String.decrypt(base: Int): String = this.map { it - base }.joinToString("")

//Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово
//только одно, но не будем его называть). Напиши метод расширения строки, который будет принимать список имён
//пользователей и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик: имя автора и букву под
//ним. Вот ссылка на референс:
//https://x.com/SadNSober_/status/1370280031616897026
fun String.twitIt(names: List<String>): String{
    if (names.isEmpty()){
        return ""
    }
    var result = ""
    for (n in this.indices){
        result += """${names[n % names.size]}
            |${this[n].uppercase()}
            |
        """.trimMargin()
    }
    return result
}

fun main() {
    println(33.within(4,55))
    println(3.5.within(6,1))
    println(89387382.within(89893849, 4567999))
    val encripted = "Привет".encrypt(1)
    println(encripted)
    println(encripted.decrypt(1))
    val names = listOf<String>("Вася","Лера","Маша")
    val str = "лидер"
    println(str.twitIt(names))
}