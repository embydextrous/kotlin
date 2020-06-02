open class A {
    private val a = 1 // visible only inside class
    val b = 2 // public accessible outside
    protected var c = 3 //accessible inside subclasses

    fun foo() {
        val d = D()
        // println("${d.e}") // e is private in D [This is allowed in Java]
        println("f is ${d.f}")
    }

    inner class D {
        private val e = 4
        val f = 5
        
        init {
            println("a: $a") // private members accessible to inner class 
        }
    }
}

class B : A() {
    fun doSomething() {
        // println("a is $a") // a is private in A
        println("c is $c")
    }
}

fun main() {
    val a = A()
    val b = B()
    // println("a is ${a.a}") // a is private
    println("b is ${a.b}")
    a.foo()
    // println("c is ${a.c}") // c is visible to subclasses only
}
