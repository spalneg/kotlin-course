package lessons.lesson19.homeworks

//Требуется описать класс, интерфейс или функцию и реализовать предложенную логику в коде.

//Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
//если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.

fun <T> getMiddleElement(list: List<T>): T?{
    if (list.size % 2 !=0){
        return list[list.size / 2]
    }
    else return null
}
//Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового
//элемента и получения всех элементов в виде неизменяемого списка.

class ListHolder<T>(){
    private val list: MutableList<T> = mutableListOf<T>()
    fun addItem(item: T){
        list.add(item)
    }
    fun getList(): List<T>{
        return list.toList()
    }
}
//Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//элементов одного типа в элементы другого типа
//списка элементов одного типа в список элементов другого типа.

interface Mapper<T, N>{
    fun mapTo(item: T): N
    fun mapListTo(items: List<T>): List<N>
}
//Создай класс PhrasesToListOfStrings и имплементируй интерфейс Mapper с типами String и List<String>. Метод
//преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
//Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings(): Mapper<String, List<String>>{
    override fun mapTo(item: String): List<String> {
        return item.split(" ")
    }

    override fun mapListTo(items: List<String>): List<List<String>> {
        return items.map { mapTo(it) }
    }
}
//Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает
//словарь, в котором ключ и значения поменялись местами.

fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    return map.entries.associate { (key, value) -> value to key }
}
//Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом
//дженерика и возвращать булево значение.

interface Validator<T>{
    fun trueOrFalse(item: T): Boolean
}
//Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку,
//что строка не является null, не пустая и не состоит из одних пробелов.

class StringValidator: Validator<String?>{
    override fun trueOrFalse(item: String?): Boolean {
        return !item.isNullOrBlank()
    }
}
//Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку,
//что число чётное.

class OddValidator: Validator<Int>{
    override fun trueOrFalse(item: Int): Boolean {
        return item % 2 == 0
    }
}
//Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator
//типизированный по типу List с nullable типом дженерика класса.
//Реализуй проверку:
//Ни один элемент списка не является null.
//Ни один элемент приведённый к типу Double не равен 0.0

class ListValidator <T: Number>: Validator<List<T?>> {
    override fun trueOrFalse(item: List<T?>): Boolean {
        for (i in item){
            if (i == null || i.toDouble() == 0.0){
                return false
            }
        }
        return true
    }
}