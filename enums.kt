// each enum constant is an object.
// It can hhave properties as `color`

enum class RGB(val color: Int) {
    R(0xFF0000) {
        override fun colorString() = "red" // enum constants can have anonymous inner classes + overriding base methods
    }, 
    G(0x00FF00) {
        override fun colorString() = "green"
    },
    B(0x0000FF) {
        override fun colorString() = "blue"
    }; // separates enum constants from members

    abstract fun colorString(): String
}

fun main() {
    try {
        // RGB.values() returns enum constants in order.
        println(RGB.values().toList())
        println(enumValues<RGB>().toList()) // genric way
        // value of method to obtain enum
        val r = RGB.valueOf("R")
        println(r)
        println(r.name) // prints String name R
        println(r.ordinal) // prints order - zero indexed
        
        val y = enumValueOf<RGB>("Y") // throws IllegalArgumentException
        println(y) 
    } catch(e: IllegalArgumentException) {
        println(e.message) // No enum constant RGB.Y
    }
}
