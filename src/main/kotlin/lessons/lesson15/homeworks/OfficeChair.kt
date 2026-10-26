package lessons.lesson15.homeworks

class OfficeChair(
    material: String,
    price: Double,
    seatHeight: Int,
    hasArmrests: Boolean,
    val hasWheels: Boolean,
    val adjustmentMechanisms: List<String>
) : SeatingFurniture(material, price, seatHeight, hasArmrests) {
}