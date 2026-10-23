package lessons.lesson13.homeworks

fun main() {
    dictAv()
    dictList()
    printTest()
    countTest()
    delTest()
    printUrl()
    find(0.5)
    api("/api/v1/logout")
    config()
    poVer()
    mobile("nokia")
    mobile("pixel")
    error(404)
    error(505)
    scenario("v1")
    scenario("v100")
    module()
    concatenate()
    dictConcatenate()
    clearDict()
    skip()
    delDict()
    makeReport()
    immutable()
    toString()
    increaseTime()
    emptyCheck(mapOf())
    emptyCheck(mapOf("error" to "error"))
    notEmptyCheck(mapOf("data" to "data"))
    notEmptyCheck(mapOf())
    checkSuccess(mapOf("test1" to "failed", "test2" to "failed", "test3" to "passed", "test4" to "skipped"))
    checkSuccess(mapOf("test1" to "passed", "test2" to "passed", "test3" to "passed", "test4" to "passed"))
    checkFail(mapOf("test1" to "failed", "test2" to "failed", "test3" to "passed", "test4" to "skipped"))
    checkFail(mapOf("test1" to "passed", "test2" to "passed", "test3" to "passed", "test4" to "passed"))
    filterOptions()

}
//Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
fun dictAv() {
    val dict = mapOf("test1" to 2.2, "test2" to 3.3)
//    var time = 0.0
//    for (entry in dict.entries) {
//        time += entry.value
//    }
//    println(time / dict.size)
    println(dict.values.average())
}
//Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов, а значения - строка с метаданными. Выведите список всех тестовых методов.
fun dictList() {
    val dict = mapOf("test1" to "data1", "test2" to "data2")
    println(dict.keys)
}
//В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
fun printTest() {
    val dict = mutableMapOf("test1" to "passed", "test2" to "skipped")
    dict["test3"] = "failed"
    println(dict)
}
//Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
fun countTest(){
    val dict = mapOf("test1" to "passed", "test2" to "failed", "test3" to "skipped", "test4" to "passed" )
    println(dict.count{it.value == "passed"})
}
//Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
fun delTest(){
    val dict = mutableMapOf("test1" to "failed", "test2" to "fixed", "test3" to "skipped", "test4" to "failed" )
    val keys = mutableSetOf<String>()
    dict.forEach { if(it.value == "fixed"){
    keys+= it.key
    }}
    for (i in keys){
            dict.remove(i)
        }

    println(dict)
}
//Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
fun printUrl(){
    val dict = mutableMapOf("ya.ru" to "failed", "google.com" to "passed", "github.com" to "skipped")
    for (entry in dict.entries){
    println("Страница ${entry.key} проверена со статусом ${entry.value}")}
}
//Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
fun find(ping: Double){
    val dict = mapOf("ya.ru" to 0.5, "google.com" to 0.7, "github.com" to 0.33)
    println(dict.filter { it.value > ping })
}
//В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки). Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
fun api(key: String){
    val dict = mapOf(
        "/api/v1/users" to "200 OK",
        "/api/v1/login" to "401 Unauthorized",
        "/api/v1/payment" to "500 Internal Server Error",
        "/api/v1/products" to "200 OK"
    )
    println(dict.getOrDefault(key, "not tested"))
}
//Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.
fun config(){
    val dict = mapOf(
        "baseUrl" to "https://example.com",
        "browserType" to null,
        "timeoutInSeconds" to "30",
        "environment" to "QA-Staging"
    )
    println(dict["browserType"]?:"Explorer")

}
//Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
fun poVer(){
    val dict = mapOf("product1" to 3.14, "product2" to 0.1, "product3" to 1.005)
    val dictCopy = dict + ("product4" to 0.1)
    println(dictCopy)
}
//Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение - строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
fun mobile(model : String){
    val dict = mapOf("nokia" to "settings nokia", "iphone100500 promax" to "settings iphone", "xiaomi" to "settings xiaomi")
    println(dict[model] ?: "default settings")
}
//Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
fun error(error: Int){
    val dict = mapOf(404 to "Not found", 403 to "Forbidden", 500 to "Internal Server Error")
    println(dict.containsKey(error))
}
//Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version", а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
fun scenario(ver: String){
    val dict = mapOf(
        "Test101_v1" to "Passed",
        "Test102_v2" to "Failed",
        "Test103_v1" to "Skipped",
        "Test104_v3" to "Passed",
        "Test105_v2" to "Passed"
    )
    val version = dict.filterKeys { it.endsWith(ver) }
    println(version)
}
//У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
fun module(){
    val moduls = mapOf(
        "AuthModule" to "Passed",
        "CartModule" to "Failed",
        "UserProfile" to "Passed",
        "PaymentGateway" to "Failed",
        "PushNotifications" to "Skipped",
        "SearchEngine" to "Passed"
    )
    println(moduls.filterValues {it == "Passed" })
}
//Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
fun concatenate(){
    val dict = mutableMapOf("test1" to "settings1", "test2" to "settings2")
    val dict2 = mutableMapOf("test3" to "settings3", "test4" to "settings4")
    dict.putAll(dict2)
    println(dict)
}
//Объедините два неизменяемых словаря с данными о багах.
fun dictConcatenate(){
    var dict = mapOf("test1" to "failed", "test2" to "failed")
    val dict2 = mapOf("test3" to "passed", "test4" to "skipped")
    dict += dict2
    println(dict)
}
//Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
fun clearDict(){
    val dict = mutableMapOf("test1" to "failed", "test2" to "failed", "test3" to "passed", "test4" to "skipped")
    dict.clear()
    println(dict)
}
//Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”). Ключи - название теста, значения - статус.
fun skip(){
    val dict = mapOf("test1" to "failed", "test2" to "failed", "test3" to "passed", "test4" to "skipped")
    println(dict.filterNot { it.value == "skipped" })

}
//Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
fun delDict(){
    val dict = mapOf("test1" to "settings1", "test2" to "settings2", "test3" to "settings3", "test4" to "settings4")
    val editedCopy = dict - "test1" - "test3"
    println(editedCopy)
}
//Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
fun makeReport(){
    val dict = mapOf("test1" to "failed", "test2" to "failed", "test3" to "passed", "test4" to "skipped")
    val report = dict.map { "Test ID: ${it.key} результат: ${it.value}" }
    println(report)
}
//Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
fun immutable(){
    val dict = mapOf("test1" to "failed", "test2" to "failed", "test3" to "passed", "test4" to "skipped")
    val rar = dict.toMap()
    println("теперь я готов к архивации: $rar" )
}
//Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов на их строковый аналог (например через toString()).
fun toString(){
    val dict = mapOf(1.1 to 6.2, 1.2 to 3.3)
    val text = dict.mapKeys { it.key.toString() }.mapValues { it.value.toString() }
    println("теперь я текст: $text")
}
//Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
fun increaseTime(){
    var dict = mapOf<String, Double>(
        "Test101_v1" to 1.0,
        "Test102_v2" to 3.0,
        "Test103_v1" to 6.0,
        )
    dict = dict.mapValues { it.value * 1.1 }
    println(dict)
}
//Проверьте, пуст ли словарь с ошибками компиляции тестов.
fun emptyCheck(compilationErrors: Map<String, String>){
    println(compilationErrors.isEmpty())
}
//Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
fun notEmptyCheck(tests: Map<String, String>) {
    println(tests.isNotEmpty())
}
//Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
fun checkSuccess(dict: Map<String, String>){
    println(dict.all {it.value == "passed"})
}
//Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
fun checkFail(dict: Map<String, String>) {
    println(dict.any { it.value == "failed" })
}
//Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.
fun filterOptions(){
    val dict =  mapOf("test1" to "failed", "test2 optional" to "failed", "test3 optional" to "passed", "test4 optional" to "skipped")
    val newDict = dict.filterNot { it.value == "passed" }
        .filter { it.key.contains("optional") }
    println(newDict)

}