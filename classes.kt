class A(name: String) {
    // static blocks and initializers run before secondary constructors as if they are part of 
    // primary constructors.
    // Also, they run in order.

    val a = "This is $name".also(::println)

    init {
        println("Runs before secondary constructor")
    }

    constructor(name: String, age: Int): this(name) {
        println("Age is $age")
    }

    init {
        println("Runs before secondary constructor too")
    }
}

fun main() {
    val a = A("Arjit", 29)
}
