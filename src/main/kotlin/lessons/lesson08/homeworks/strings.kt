package lessons.lesson08.homeworks

//Если фраза содержит слово "невозможно":
//Преобразование: Замените "невозможно" на "совершенно точно возможно, просто требует времени".
//Если фраза начинается с "Я не уверен":
//Преобразование: Добавьте в конец фразы ", но моя интуиция говорит об обратном".
//Если фраза содержит слово "катастрофа":
//Преобразование: Замените "катастрофа" на "интересное событие".
//Если фраза заканчивается на "без проблем":
//Преобразование: Замените "без проблем" на "с парой интересных вызовов на пути".
//Если фраза содержит только одно слово:
//Преобразование: Добавьте перед словом "Иногда," и после слова ", но не всегда".

fun main() {
    textReplace("Это невозможно выполнить за один день")
    textReplace("Я не уверен в успехе этого проекта")
    textReplace("Произошла катастрофа на сервере")
    textReplace("Этот код работает без проблем")
    textReplace("Удача")
    dateTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    hideCard("4539 1488 0343 6467")
    mailConv("username@example.com")
    fileName("C:/Пользователи/Документы/report.txt")
    abb("Котлин лучший язык программирования")
}

fun textReplace(phrase: String) {

    val result = when {
        phrase.contains("невозможно", true) -> phrase.replace(
            "невозможно",
            "совершенно точно возможно, просто требует времени",
            true
        )

        phrase.startsWith("Я не уверен", true) -> "$phrase, но моя интуиция говорит об обратном"
        phrase.contains("катастрофа", true) -> phrase.replace("катастрофа", "интересное событие", true)
        phrase.endsWith("без проблем", true) -> phrase.replace(
            "без проблем",
            "с парой интересных вызовов на пути",
            true
        )

        !phrase.contains(" ") -> "Иногда, $phrase, но не всегда"
        else -> phrase
    }
    println(result)
}

//У вас есть строка лога, например "Пользователь вошел в систему -> 2021-12-01 09:48:23" (данные могут быть любыми, но формат всегда такой).
// Извлеките отдельно дату и время из этой строки и сразу распечатай их по очереди. Используй indexOf или split для получения правой части сообщения.

fun dateTime(log: String) {
    val dateStart = log.indexOf("->") + 3
    val timeDate = log.substring(dateStart)
    val result = timeDate.split(" ")
    println(result[0])
    println(result[1])
}

//Дана строка с номером кредитной карты, например "4539 1488 0343 6467". Замаскируйте все цифры, кроме последних четырех, символами "*".

fun hideCard(number: String) {
    val result = "**** **** **** ${number.substring(number.length - 4)}"
    println(result)
}

//У вас есть электронный адрес, например "username@example.com". Преобразуйте его в строку "username [at] example [dot] com", используя функцию replace()

fun mailConv(email: String) {
    val result = email
        .replace("@", " [at] ")
        .replace("."," [dot] ")
    println(result)
}

//Дан путь к файлу, например "C:/Пользователи/Документы/report.txt" или "D:/good.themes/dracula.theme" (может быть любым). Извлеките название файла с расширением.

fun fileName(path: String) {
    val split = path.split("/")
    val result = split[split.size - 1]
    println(result)
}

//У вас есть фраза, например "Котлин лучший язык программирования" (может быть любой с разделителями слов - пробел). Создайте аббревиатуру из начальных букв слов (например, "ООП").
//Используйте split. Используйте for для перебора слов. Используйте var переменную для накопления первых букв.

fun abb(phrase: String) {
    val split = phrase.split(" ")
    var result = ""
    for (i in split) {
        result += i[0].uppercase()
    }
    println(result)
}

