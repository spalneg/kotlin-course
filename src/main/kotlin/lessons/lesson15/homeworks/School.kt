package lessons.lesson15.homeworks

abstract class School(
    capacity: Int,
    onlineClasses: Boolean,
    grades: Int,
    rating: Double,
): Education(capacity, onlineClasses, rating) {
}