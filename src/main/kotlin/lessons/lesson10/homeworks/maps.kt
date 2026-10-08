package lessons.lesson10.homeworks

import java.util.Date

fun main(){
    println(emptyMap)
    println(any)
    println(mutable)
    adding()
    getMap()
    delMap()
    devMap()
    rename()
    concatMap()
    addMap()
    printMap()
    pair()
}
//Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
val emptyMap = mapOf<Int, Int>()
//Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
val any = mapOf(0.5f to 0.5, 0.7f to 0.7, 0.33f to 0.33)
//Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
val mutable = mutableMapOf<Int, String>(1 to "One", 2 to "Two")
//Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
fun adding() {
    val mutableAdd = mutableMapOf<Int, String>(1 to "One", 2 to "Two")
    mutableAdd[3] = "Three"
    println(mutableAdd)
}
//Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
fun getMap() {
    val mutableAdd = mutableMapOf<Int, String>(1 to "One", 2 to "Two")
    println(mutableAdd[1])
}
//Удалите определенный элемент из изменяемого словаря по его ключу.
fun delMap(){
    val mutableDel = mutableMapOf<Int, String>(1 to "One", 2 to "Two")
    mutableDel.remove(1)
    println(mutableDel)
}
//Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
fun devMap(){
    val map = mapOf<Double, Int>(10.0 to 2, 8.0 to 2, 42.0 to 0)
    for ((i, n) in map) {
        if (n == 0){
            println("бесконечность")
        }
        else println(i/n)
    }
}
//Измените значение для существующего ключа в изменяемом словаре.
fun rename(){
    val map = mutableMapOf<Int, String>(1 to "One", 2 to "Two")
    map[2] = "42"
    println(map)
}
//Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
fun concatMap(){
    val mapOne = mapOf<Int, String>(1 to "One", 2 to "Two")
    val mapTwo = mapOf<Int, String>(3 to "Three", 4 to "Four")
    val result = mapOne+mapTwo
    println(result)
}
//Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
fun addMap(){
    val addMap = mutableMapOf<String, Int>("One" to 1, "Two" to 2)
    addMap["Three"] = 3
    addMap["Four"] = 4
    println(addMap)
}
//Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
fun printMap(){
    val map = mutableMapOf<Int,MutableSet<String>>()
    val setOfString = mutableSetOf("Это", "множество", "строк")
    val setOfString2 = mutableSetOf("Ещё", "одно")
    map[1] = setOfString
    map[2] = setOfString2
    val result = map[2]
    result?.add("добавленное слово")
    println(result)
}
//Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
fun pair(){
    val map = mapOf((1 to 5) to 42, (0 to 6) to 33, (5 to 2) to 88)
    for ((i, n) in map){
        if (i.first == 5  || i.second == 5){
            println(map[i])
        }
    }
}
//Задачи на подбор оптимального типа для словаря
//Словарь библиотека: Ключи - автор книги, значения - список книг
val library: Map<String, List<String>> = mutableMapOf()
//Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
val directory: Map<String, List<String>> = mutableMapOf()
//Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
val final: Map<String, List<String>> = mutableMapOf()
//Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
val cure: Map<Date, String> = mutableMapOf()
//Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
val travelerGuide: Map<String, Map<String, List<String>>> = mutableMapOf()
