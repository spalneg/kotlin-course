package lessons.lesson16.homeworks
//Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()
object Colors {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}
object Background {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}
fun printColored(text: String, color: String, backgroundColor: String = "") {
    println("$color$backgroundColor$text${Colors.RESET}")
}
abstract class Animal {
    open fun makeSound(){
        printColored("This animal makes no sound.", Colors.BLACK, Background.WHITE)
    }
}
class Dog: Animal(){
    override fun makeSound() {
        printColored("Bark", Colors.BLUE)
    }
}
class Cat: Animal(){
    override fun makeSound() {
        printColored("Meow", Colors.CYAN)
    }
}
class Bird: Animal(){
    override fun makeSound() {
        printColored("Tweet", Colors.YELLOW)
    }
}
fun main(){
    val dog = Dog()
    val cat = Cat()
    val bird = Bird()
    val animals: List<Animal> = listOf(dog, cat, bird)
    animals.forEach {
        it.makeSound()
    }
}