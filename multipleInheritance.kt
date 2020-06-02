interface P {
    fun doSomething() {
        println("P's doSomething()")
    }
}

interface Q {
    fun doSomething() {
        println("Q's doSomething()")
    }
}

class C : P, Q {
    override fun doSomething() {
        super<P>.doSomething()
        super<Q>.doSomething()
        println("C's doSomething()")
    }
}

fun main() {
    val c = C()
    c.doSomething()
}
