package lessons.lesson14.homeworks
//Задание 6. Стеллаж и полки.
//Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
//Класс Shelf (Полка Стеллажа)
//Характеристики:
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
//Список предметов (items): хранит названия предметов на полке.
//Методы:
//Добавление Предмета (addItem):
//Принимает название предмета.
//Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
//Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
//Удаление Предмета (removeItem):
//Принимает название предмета.
//Удаляет предмет, если он найден на полке.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка Вместимости (canAccommodate):
//Принимает название предмета.
//Определяет, вместится ли предмет на полку.
//Возвращает true, если предмет вместится, и false, если места недостаточно.
//Проверка наличия предмета (containsItem):
//Принимает название предмета.
//Возвращает true если такой предмет есть
//Получение списка предметов (getItems):
//Возвращает неизменяемый список предметов
class Shelf(val capacity: Int){
    private var items = mutableListOf<String>()
    val remainingCapacity = capacity - items.sumOf { it.length }
    fun addItem(item: String): Boolean{
        if (canAccommodate(item)){
        items.add(item)
            return true}
        return false
    }
    fun removeItem(item: String): Boolean = items.remove(item)

    fun canAccommodate(item: String): Boolean{
        return  remainingCapacity + item.length <= capacity
    }
    fun containsItem(item: String): Boolean = (item in items)

    fun getItems(): List<String> = items.toList()
    }
