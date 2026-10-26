package lessons.lesson15.homeworks

abstract class Polygon (
    val cornerNumber: Int,
    val sideLength: Int,
    shapeArea: Int,
    symmetry: Boolean
)
    :Geometry(shapeArea, symmetry)