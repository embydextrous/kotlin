class A {
    // outer class cannot access private members of inner class in Kotlin. It can do so in Java.
    private val a = "Arjit"
    // anonymous inner classes using object, same visibility thing as inner classes.
    val c: Runnable = object : Runnable {
        override fun run() {
            println("I am a runnable")
        }
    }

    init {
        c.run()
    }

    // cannot reference A's member
    class B {
        fun print() {
            // println(a) // won't compile
        }
    }

    // can access A's member
    inner class C {
        fun print() {
            println(a) // have access to outer class members [implicity references outer object as non-static inner classes do in java]
        }
    }
}

fun main() {
    val a = A()
    val c = a.C() // inner class constructor can only be called on instances of A
    val b = A.B() // simple class inside another class can be called on class A
    c.print()
}
