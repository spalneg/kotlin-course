package lessons.lesson17.homeworks

//Почемучка
//Нужно скопировать код к себе и постараться ответить на все “почему” в комментариях и заданным образом доработать
//класс ChildrenClass (BaseClass доработке не подлежит)
abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. объясни, почему эта функция не может быть публичной
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. объясни, почему эта функция не может быть публичной или protected
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    publicVal: String,

) : BaseClass(privateVal, protectedVal, publicVal) {
    //4. переписать функцию verifyPublicField
    override fun verifyPublicField(value: String): Boolean {
        return true
    }
    //5. создать сеттер через новую переменную
    var protectedFieldModified: String
        get() = protectedField
        set(value){
            protectedField = value
        }

    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}
//1. В ChildrenClass privateVal создаётся заново как публичное поле (val privateVal: String).
//2. protected доступна только в пределах класса и дочерних классов.
//3.
fun main(){

    val childrenClass = ChildrenClass("1","2","3")
    childrenClass.publicField = "Антонио Бандерас"
//5. задаём новое значение:
    childrenClass.protectedFieldModified = "Новое значение пункта 5"
    println(childrenClass.getAll())
    childrenClass.printText()
}
//6. Это невозможно без изменения базового класса
//7. Функция не может быть более видимой чем возвращаемое значение
//8. Функция генерации перезаписана в дочернем классе
//9. Функция не может быть более видимой чем возвращаемое значение
//10. publicVal наследуется от базового класса
//11. getAll публичная и наследуется от родительского класса
//12. В printText лежит private функция, она не переопределяется в наследнике, потому что они друг друга не видят.
