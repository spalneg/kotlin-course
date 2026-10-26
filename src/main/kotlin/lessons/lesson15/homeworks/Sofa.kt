package lessons.lesson15.homeworks

class Sofa(
    material: String,
    price: Double,
    seatHeight: Int,
    val numberOfSeats: Int,
    val isConvertible: Boolean
) : SeatingFurniture(material, price, seatHeight, hasArmrests = true) {
}