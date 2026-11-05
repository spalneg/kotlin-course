package lessons.lesson17.homeworks

import com.sun.org.apache.xpath.internal.operations.Equals

//Расширяемый текстовый калькулятор
//Общие требования
//Ввод и вывод:
//Калькулятор должен принимать на вход строку, содержащую два операнда и оператор между ними (например, "3 + 4" именно так - в виде строки а не отдельных аргументов).
//Результатом работы калькулятора всегда является строка, даже если операнды и результат операции являются числовыми значениями.
//Расширяемость:
//Система должна позволять внедрение обработки пользовательских операторов без изменения исходного кода калькулятора.
//Должна быть предусмотрена возможность добавления новых типов операций в калькулятор через внешние классы.
//Спецификация
//Операции:
//Калькулятор должен поддерживать базовые арифметические операции: сложение, вычитание, умножение, деление и получение остатка от деления.
//Каждая операция реализуется в отдельном классе, наследующем общий абстрактный класс, определяющий структуру операции.
//Абстрактный класс операций "Operation":
//Должен содержать метод для выполнения операции, который будет переопределен в классах конкретных операций.
//Должен предоставлять методы для проверки применимости операции к заданному выражению и для разбиения выражения на операнды.
//Класс калькулятора:
//Должен содержать механизм выбора подходящей операции для заданного выражения.
//Должен предусматривать выполнение операции и возвращение результата в виде строки.
//Должен поддерживать добавление новых операций через конструктор или специальный метод.
//Ограничение доступа:
//Требуется ограничить доступ к полям и методам, не предполагающих прямой доступ.
//Требуется ограничить доступ к классам стандартных операций областью видимости калькулятора, чтобы извне калькулятора
// эти классы не было доступны.
//Тестирование
//
//Предусмотреть тестовые случаи для проверки работы калькулятора с различными встроенными и пользовательскими операциями.
//Тестовые случаи должны включать только числовые операнды, а также проверку корректности обработки неподдерживаемых
//операций.
//
abstract class Operation(private val operator: String) {
    abstract fun operate(expression: String): String
    fun check(expression: String): Boolean {
        return expression.contains(operator)
    }
    protected fun split(expression: String): List<Double> {
        return expression.split(operator)
            .map { it.trim() }
            .map { it.toDouble() }
    }
}
private class Addition : Operation("+") {
    override fun operate(expression: String): String {
        return split(expression).sum().toString()
    }
}
private class Subtraction : Operation("-") {
    override fun operate(expression: String): String {
        val operands = split(expression)
        return (operands[0] - operands[1]).toString()
    }
}
private class Multiplication : Operation("*") {
    override fun operate(expression: String): String {
        val operands = split(expression)
        return (operands[0] * operands[1]).toString()
    }
}
private class Division : Operation("/") {
    override fun operate(expression: String): String {
        val operands = split(expression)
        return if (operands[1] == 0.0) {
            "Division by zero"
        } else {
            (operands[0] / operands[1]).toString()
        }
    }
}
private class Remainder : Operation("%") {
    override fun operate(expression: String): String {
        val operands = split(expression)
        return (operands[0] % operands[1]).toString()
    }
}
class Calculator(private val customOperations: List<Operation>) {
    private val operations = listOf(
        Addition(),
        Subtraction(),
        Multiplication(),
        Division(),
        Remainder()
    ) + customOperations
    fun operate(expression: String): String {
        val operation = operations.firstOrNull { it.check(expression) }
        if (operation == null) {
            return "Unsupported operator in the expression '$expression'"
        }
        return operation.operate(expression)
    }
}

fun main() {
    val calculator = Calculator(listOf())
    println(calculator.operate("3 + 5"))
    println(calculator.operate("3 * 5"))
    println(calculator.operate("3 / 5"))
    println(calculator.operate("3 - 5"))
    println(calculator.operate("10 % 7"))
    println(calculator.operate("3 == 5"))
}