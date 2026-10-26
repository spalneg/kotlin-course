package lessons.lesson15.homeworks

class OutdoorFurniture(
    material: String,
    price: Double,
    val maxTemperature: Int,
    val minTemperature: Int
) : Furniture(material, price){
}