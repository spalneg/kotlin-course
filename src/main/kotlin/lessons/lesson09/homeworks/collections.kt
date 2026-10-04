package lessons.lesson09.homeworks

import kotlin.collections.contentToString

fun main(){
    ex1()
    ex2()
    ex3()
    ex4()
    ex5()
    ex6()
    ex7(arrayOf(1,2,5,7))
    ex7(arrayOf(1,2,7))
    ex8(arrayOf(1,2,5,7))
    ex9(arrayOf("привет","как дела","это надо распечатать, потому что гладиолус"),"гладиолус")
    ex10()
    ex11(listOf(6, 7, 8))
    ex12("World")
    ex13(listOf(1,2,3,4,5))
    ex14()
    ex15()
    ex16(listOf("first", "list","concatenation"), listOf("second", "list", "concatenation"))
    ex17(listOf(6,19,5,1,7,-1))
    ex18(listOf(1,5,8,16,7,88))
    ex19(setOf("Kotlin", "Java", "Scala"))
    ex20(mutableSetOf("Kotlin", "Java", "Scala"))
    ex22(setOf(1,5,8,16,7,88))
    ex23(setOf("first","list","concatenation"), "concatenation")
    ex23(setOf("first","list","concatenation"), "false expected")
    ex24(setOf("Hello", "Print it", "World", "Bye"))
}
//Работа с массивами Array.
//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
fun ex1() {
    val numbers = arrayOfNulls<Int>(5)
    for (n in numbers.indices){
        numbers[n] = n + 1}
    println(numbers.contentToString())
}
//Создайте пустой массив строк размером 10 элементов.
val emptyArray = Array(10){""}
//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
fun ex2() {
    val numbers = arrayOfNulls<Double>(5)
    for (n in numbers.indices){
        numbers[n] = n*2.toDouble()}
    println(numbers.contentToString())
}
//Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
fun ex3() {
    val numbers = arrayOfNulls<Int>(5)
    for (n in numbers.indices){
        numbers[n] = n * 3}
    println(numbers.contentToString())
}
//Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
fun ex4() {
    val numbers = arrayOfNulls<Any>(3)
    for (n in numbers.indices){
        if (n == 0) {
            continue
        }
        else {
            numbers[n] = ""
        }}
    println(numbers.contentToString())

}
//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
fun ex5(){
    val arrayF = arrayOf(1, 2, 3, 4, 5)
    val numbers = arrayOfNulls<Any>(5)
    for (n in numbers.indices){
        numbers[n] = arrayF[n]
    }
    println(numbers.contentToString())
}
//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
fun ex6(){
    val arrayA = arrayOf(4, 8, 12, 16, 20)
    val arrayB = arrayOf(3, 6, 9, 12, 15)
    val numbers = arrayOfNulls<Any>(5)
    for (n in numbers.indices){
        numbers[n] = arrayA[n] - arrayB[n]
    }
    println(numbers.contentToString())
}
//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
fun ex7(numbers: Array<Int>){
    var index = numbers.lastIndex
    var num = 0
    var result = 0
    while(num <= index){
        if (numbers[num] == 5){
            result+= 1
            println(num++)
        }
    else num++
        continue
    }
    if (result == 0){
        println(-1)
    }
}
//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
fun ex8(numbers: Array<Int>){
    var index = numbers.lastIndex
    var num = 0
    while(num <= index){
        if (numbers[num]%2 == 0){

            println("${numbers[num++]} чётное")
        }
        else println("${numbers[num++]} нечётное")

    }}
//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
fun ex9(array: Array<String>, search: String){
    for (n in array.indices){
        if (array[n].contains(search)){
            println(array[n])
        }
    }
}
//Работа со списками List
//Создайте пустой неизменяемый список целых чисел.
val list: List<Int> = emptyList()
//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
val list2: List<String> = listOf("Hello", "World", "Kotlin")
//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
fun ex10(){
    val list: MutableList<Int> = mutableListOf()
    for (i in 1..5){
        list.addLast(i)
    }
    println(list)
}
//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
fun ex11(listA: List<Int>){
    val list: MutableList<Int> = mutableListOf(1,2,3,4,5)
    list.addAll(listA)
    println(list)
}
//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
fun ex12(del: String){
    val list: MutableList<String> = mutableListOf("Hello", "World")
    list.remove(del)
    println(list)
}
//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
fun ex13(print: List<Int>){
    for(i in print){
        println("++${i}++")
    }
}
//Создайте список строк и получите из него второй элемент, используя его индекс.
fun ex14(){
    val list: List<String> = listOf("Hello", "Print it", "World", "Bye")
    println(list[1])
}
//Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
fun ex15(){
    val list: MutableList<Int> = mutableListOf(1,2,0,4,5)
    list[2] = 3
    println(list)
}
//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
fun ex16(listF: List<String>, listS: List<String>){
    val list: MutableList<String> = mutableListOf()
    for(i in listS.indices){
        list.add(listF[i])
        list.add(listS[i])

    }
    println(list)
}
//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
fun ex17(list: List<Int>){
    var max = list[0]
    var min = list[0]
    for (i in list){
        if (i>max){
            max = i
        }
        else if (i<min){
            min = i
        }
    }
    println("max: ${max}, min: ${min}")
}
//Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
fun ex18(list: List<Int>){
    var evenList: MutableList<Int> =mutableListOf()
    for (i in list){
        if(i%2 == 0){
            evenList.addLast(i)
        }
    }
    println(evenList)
}
//Работа с Множествами Set.
//Создайте пустое неизменяемое множество целых чисел.
val set: Set<Int> = emptySet()
//Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
val set2: Set<Int> = setOf(1,2,3)
//Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
fun ex19(setStr: Set<String>){
    val set: MutableSet<String> = mutableSetOf()
    for (i in setStr){
        set.add(i)
    }
    println(set)}

//Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
fun ex20(setS: MutableSet<String>){
    setS.addAll(setOf("Swift", "Go"))
    println(setS)
}
//Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
fun ex21(){
    val set: MutableSet<Int> = mutableSetOf(1,2,3,4)
    set.remove(2)
    println(set)
}
//Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
fun ex22(toPrint: Set<Int>){
    for(i in toPrint){
        println("==${i}==")
    }
}
//Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно распечатать булево значение true если строка есть. Реши задачу через цикл.
fun ex23(set: Set<String>,string: String){
    for(i in set){
        println((i == string))
    }}
//Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
fun ex24(set: Set<String>){
    val MSet: MutableSet<String> = mutableSetOf()
    for (i in set){
        MSet.add(i)
    }
    println(MSet)
}