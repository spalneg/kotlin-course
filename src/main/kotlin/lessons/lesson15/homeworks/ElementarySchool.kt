package lessons.lesson15.homeworks

class ElementarySchool(
    val classNap: Boolean,
    val ageRestriction: Int,
    capacity: Int,
    onlineClasses: Boolean,
    grades: Int,
    rating: Double
    ): School(capacity, onlineClasses, grades, rating) {
}