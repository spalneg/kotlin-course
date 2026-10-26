package lessons.lesson15.homeworks

class University(
    capacity: Int,
    onlineClasses: Boolean,
    rating: Double,
    val faculties: List<String>
) : Education(capacity, onlineClasses, rating) {
}