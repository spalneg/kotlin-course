package lessons.lesson08.homeworks

fun main() {
    upper("Напишите метод, который преобразует строку из нескольких слов в строку")
    encrypt("Напишите шифратор/дешифратор для строки")
    decrypt("аНипишетш фиарот/редишрфтарод ялс ртко и")
    printTable(15, 15)
}
//Напишите метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается
// с заглавной буквы, а все остальные - строчные. Используй перебор, анализ символов и замену букв на заглавную
// с помощью метода uppercase() для конкретной буквы.

fun upper(phrase: String) {
    var result = ""
    for (i in 0..<phrase.length) {
        if (i == 0 || phrase[i - 1] == ' ') {
            result += phrase[i].uppercase()
        } else result += phrase[i]
    }
    println(result)
}

//Напишите шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой: Kotlin шифруется в oKltni. Дешифровка выполняется аналогично.
//Если длина строки - нечётная, в конец добавляется символ пробела до начала шифрования. Таким образом все шифрованные сообщения будут
//с чётной длиной. Должно получиться два публичных метода: encrypt() и decrypt() которые принимают строку и печатают результат в консоль.

fun encrypt(phrase: String) {
    var result = ""
    var phraseOdd = ""
    if (phrase.length % 2 != 0) {
        phraseOdd = "$phrase "
    } else phraseOdd = phrase
    for (i in 0..<phraseOdd.length step 2) {
        result += phraseOdd.substring(i, i + 2).reversed()
    }
    println(result)

}

fun decrypt(phrase: String) {
    var result = ""
    for (i in 0..<phrase.length step 2) {
        result += phrase.substring(i, i + 2).reversed()
    }
    println(result)

}

fun printTable(rows: Int, cols: Int) {

    val width = (rows * cols).toString().length
    var result = 0
    print(" ".repeat(width))
    for (i in 1..cols) {
        print(" " + "%${width}d".format(i))
    }
    println()
    for (i in 1..cols) {
        print("%${width}d".format(i))
        for (n in 1..rows) {
            result = i * n
            print(" " + "%${width}d".format(result))

        }
        println("")
    }

}