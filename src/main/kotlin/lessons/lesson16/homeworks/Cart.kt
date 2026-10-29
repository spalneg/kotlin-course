package lessons.lesson16.homeworks
//Перегрузка методов
//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину.
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.
//Класс “Логгер”: представляет собой инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO.
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO.
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR.
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.
class Cart {
    val products: MutableMap<Int, Int> = mutableMapOf()
    fun addToCart(itemId: Int){
        products[itemId] = products.getOrDefault(itemId, 0) + 1
    }
    fun addToCart(itemId: Int, amount: Int){
        products[itemId] = products.getOrDefault(itemId, 0) + amount
    }
    fun addToCart(product: Map<Int, Int>){
        products.putAll(product)
    }
    fun addToCart(idsList: List<Int>){
        idsList.forEach {
            products[it] = products.getOrDefault(it,0) + 1
        }
    }
    override fun toString(): String{
        if (products.isEmpty()) {
            return "Корзина пуста"
        }
        var result = "-----------------------\n"
        result += "| %-10s | %5s |\n".format("ID Товара", "Кол-во")
        result += "-----------------------\n"
        for ((itemId, quantity) in products) {
            result += "| %-10d | %5d |\n".format(itemId, quantity)
        }
        val totalCount = products.values.sum()

        result += "-----------------------\n"
        result += "Всего артикулов: ${products.size}\n"
        result += "Всего товаров: $totalCount"

        return result
    }
}
fun main(){
    val cart = Cart()
    cart.addToCart(44)
    cart.addToCart(42,10)
    cart.addToCart(mutableMapOf(55 to 66, 88 to 100))
    cart.addToCart(listOf(1,2,3,4,5))
    println(cart)
}