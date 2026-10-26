package lessons.lesson15.homeworks
//Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземпляр этого класса, он нужен только для того, чтобы быть основой для подклассов.
//Создай подклассы этого контейнера, которые будут добавлять строку material (или коллекции или словари строк) в какое-то определённое место (места).
//Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
//Второй класс должен получать список строк и вставлять их в начало контейнера, но поочерёдно с теми данными, которые
//уже есть. То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
//Третий класс при добавлении строки должен отсортировать весь список материалов в алфавитном порядке включая добавляемый материал.
//Четвёртый класс должен принимать словарь (ключи и значения строки). Каждая пара ключа и значения должна попадать
// в контейнер следующим образом - ключ в начало, значение в конец. Таким образом в начале должны быть ключи в обратном
// порядке, потом существующие материалы, потом все значения.

abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}
open class ZeroIndex: Materials(){
    fun addToZero(string: String){
        val materials = extractMaterials()
        addMaterial(string)
        materials.forEach { addMaterial(it) }

}
}
class MixData: Materials(){
    fun mixData(list: List<String>){
        val old = extractMaterials()
        val maxIndex = maxOf(list.size, old.size)

        for (i in 0 until maxIndex){
            if (i < list.size) addMaterial(list[i])
            if (i < old.size) addMaterial(old[i])
        }
    }
}
class SortData: Materials(){
    fun sortData(string: String){
        addMaterial(string)
        var materials = extractMaterials()
        materials = materials.sorted()
        materials.forEach { addMaterial(it) }

    }
}
class KeyValueContainer: ZeroIndex(){
    fun keyValueContainer(map: Map<String, String>){
        for (entry in map.entries){
            addToZero(entry.key)
            addMaterial(entry.value)
        }
    }
}