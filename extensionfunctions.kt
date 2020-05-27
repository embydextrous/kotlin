open class Shape
class Rectangle: Shape() {
    fun getName() = "Rect"
}

fun main(args: Array<String>) {
    val a: Shape = Rectangle()

    // this shall print `Shape` - Extensions are resolved statically (at compile time)
    println(a.getName())

    // this shall print 'Rect' - Extensions functions are shadowed by similar signature member functions
    val b: Rectangle = Rectangle()
    println(b.getName())
}

fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle"
