package lessons.lesson15.homeworks

class HighSchool(
    capacity: Int,
    onlineClasses: Boolean,
    grades: Int,
    rating: Double,
    val finalExams: Map<String, Int>
) : School(capacity, onlineClasses, grades, rating) {
}