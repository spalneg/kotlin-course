package lessons.lesson16.homeworks

import lessons.lesson10.homeworks.pair

//Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом
//фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на
// цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по
// этому списку при выводе текста. Проверить работу на длинном тексте

abstract class Printer {
    abstract fun printit(string: String)
}

class LaserPrinter() : Printer() {
    override fun printit(string: String) {
        val list = string.split(" ")
        list.forEach {
            printColored(it, Colors.BLACK, Background.WHITE)
        }
    }

}

class InkjetPrinter() : Printer() {
    val RESET = "\u001B[0m"
    val TEXT_COLORS = listOf("\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m")
    val BG_COLORS = listOf("\u001B[47m", "\u001B[40m", "\u001B[44m", "\u001B[42m", "\u001B[41m", "\u001B[45m")
    override fun printit(string: String) {
        val list = string.split(" ")
        for (i in list.indices){
            val color = TEXT_COLORS[i % TEXT_COLORS.size]
            val bg = BG_COLORS[i % BG_COLORS.size]
            print("$color$bg${list[i]}${RESET} ")
        }
        println()
    }
}
fun main(){
    val lp = LaserPrinter()
    val ip = InkjetPrinter()
    lp.printit("Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно" +
            " чёрными буквами на белом фоне (хорошо работает на тёмной теме)")
    ip.printit("Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно " +
            "цветными буквами на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста " +
            "и фона и проходить циклически по этому списку при выводе текста. Проверить работу на длинном тексте")
}