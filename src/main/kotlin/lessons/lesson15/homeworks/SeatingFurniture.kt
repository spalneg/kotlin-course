package lessons.lesson15.homeworks

abstract class SeatingFurniture(
    material: String,
    price: Double,
    val seatHeight: Int,
    val hasArmrests: Boolean
) : Furniture(material, price)
{
}