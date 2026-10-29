package lessons.lesson16.homeworks
//Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
//Создай набор геометрических фигур и выведи в цикле их площадь
abstract class Shape {
    open fun area(): Double{
        return 0.0
    }
}
class Circle(val radius: Double): Shape(){
    override fun area(): Double {
        return 3.14 * radius * radius
    }
}
class Square(val side: Double): Shape(){
    override fun area(): Double {
        return side * side
    }
}
class Triangle(val side1: Double, val side2: Double, val angle: Double): Shape(){
    override fun area(): Double{
        val radians = angle * kotlin.math.PI / 180.0
        val sinValue = kotlin.math.sin(radians)
        return 0.5 * side1 * side2 * sinValue
    }
}
fun main(){
    val circle =  Circle(10.0)
    val square = Square(5.0)
    val triangle = Triangle(5.0, 6.0, 30.0)
    val figures: List<Shape> = listOf(circle,square,triangle)
    figures.forEach {
        println(it.area())
    }
}