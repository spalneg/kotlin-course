package lessons.lesson7.homeworks


//Напишите цикл for, который выводит числа от 1 до 5.
fun main() {
    for (i in 1..5) {
        println(i)
    }

//Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i in 1..10) {
        if (i % 2 == 0) println(i)
    }
//    Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        println(i)
    }
//    Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
//Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (i in 1..9 step 2) {
        println(i)
    }
//Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i in 1..20 step 3) {
        println(i)
    }
//Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size = 10
    for (i in 3..<size step 2) {
        println(i)
    }

//Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var counter = 1
    while (counter <= 5) {
        println(counter * counter++)
    }

//Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var counter2 = 10
    while (counter2 > 5) {
        counter2--
    }
    println(counter2)

//Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var counter3 = 5
    do {
        println(counter3--)
    } while (counter3 >= 1)
//Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var counter4 = 5
    do {
        counter4++

    } while (counter4 < 10)

//Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i in 1..10) {
        if (i == 6) break
    }
//Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
    var counter5 = 1
    while (true) {
        println(counter5)
        if (counter5 == 10) break
        counter5++
    }
//В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }
//Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var counter6 = 1
    while (counter6 <= 10) {
        if (counter6 % 3 == 0) {
            counter6++
            continue
        }
        println(counter6++)
    }

//Используя вложенный цикл реализовать таблицу умножения, как на картинке.
    for (i in 1..10) {
        for (n in 1..10) {
            print(" ${i * n} ")

        }
        println("")
    }

    println(sumTo(10))
    println(factCalc(10))
    println(sumEven(10))
    draw()
    val result = sumEvenOdd(10)
    println(result.first)
    println(result.second)
}

//Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for. 'arg' - целочисленный аргумент функции.
fun sumTo(arg: Int): Int {

    var result = 0
    for (i in 1..arg) {
        result += i
    }
    return result
}

//Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
fun factCalc(arg: Int): Int {

    var fact = 1
    var result = 1
    while (fact < arg) {
        result *= ++fact
    }
    return result
}

//Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
fun sumEven(arg: Int): Int {

    var sum = 2
    var result = 0
    while (sum <= arg) {
        if (sum % 2 == 0) {
            result += sum++

        } else {
            sum++
            continue
        }
    }
    return result
}

//Напишите функцию, которая используя вложенные циклы while, выведет заполненный прямоугольник размером 5x3 из символов *.
fun draw() {

    var layers = 1
    while (layers <= 3) {
        var stars = 1

        while (stars <= 5) {
            print("*")
            stars++
        }
        println()
        layers++
    }
}

//Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg
fun sumEvenOdd(arg: Int): Pair<Int, Int> {

    var even = 0
    var odd = 0
    for (i in 1..arg) {
        if (i % 2 == 0) {
            even += i
        } else {
            odd += i
        }
    }
    return Pair(even, odd)
}

