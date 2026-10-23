package lessons.lesson14.homeworks
//Класс Rack (Стеллаж)
//Характеристики:
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.
//Методы:
//Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
//Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
//Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления.
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами.
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.

class Rack(private val max: Int) {
    private var shelves = mutableListOf<Shelf>()

    fun addShelf(shelf: Shelf): Boolean {
        if (shelf in shelves || shelves.size >= max) {
            return false
        }
        shelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        if (index in shelves.indices) {
            val result = shelves[index].getItems()
            shelves.removeAt(index)
            return result
        }
        return emptyList<String>()

    }

    fun addItem(item: String): Boolean {
        for (i in shelves) {
            if (i.canAccommodate(item)) {
                i.addItem(item)
                return true
            }
        }
        return false

    }

    fun removeItem(item: String): Boolean {
        for (i in shelves) {
            if (i.removeItem(item)) {
                return true
            }
        }
        return false
    }

    fun containsItem(item: String): Boolean {
        for (i in shelves) {
            if (i.containsItem(item)) {
                return true
            }
        }
        return false
    }

    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    fun printContents() {
        for (i in shelves.indices) {
            println(
                """индекс: ${i}
            |вместимость: ${shelves[i].capacity}
            |оставшаяся вместимость: ${shelves[i].remainingCapacity}
            |список предметов: ${shelves[i].getItems()}""".trimMargin()
            )
        }
    }

    fun advancedRemoveShelf(ind: Int): List<String> {
        if (ind !in shelves.indices) return emptyList()
        val delShelf = removeShelf(ind).toMutableList()
        val result = mutableListOf<String>()
        delShelf.sortByDescending { it.length }
        for (item in delShelf) {
            var placed = false
            for (index in shelves.indices) {
                if (shelves[index].canAccommodate(item)) {
                    shelves[index].addItem(item)
                    placed = true
                    break
                }
            }
            if (!placed) result.add(item)
        }
        return result.toList()
    }
}
