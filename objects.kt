// object declaration invoked lazily and is thread safe. Can be used against Singletons. I won't recommend though.
object A {
    fun doSomething() { System.out.println ("Object declaration") }
}

interface B {
    fun foo()
}

open class C {

    // object expressions, initialized when we make instance of B
    val a = object : B {
        override fun foo() { println("Anonymous implementation of B") }
    }

    val d = 2

    // objects with no supertypes
    // type inferenced is Any
    val b = object {
        val x: Int = d // can access from outer scope
        val y: Int = 3

        fun addition(): Int = x + y
    }

    fun doSomething() {
        // A is created now.
        val e = object {
            val x: Int = d // can access from outer scope
            val y: Int = 3

            fun addition(): Int = x + y
        }
        println(e.addition()) // this works locally
        A.doSomething()
    }

    // only 1 per class, can be named explicitly
    //  even though the members of companion objects look like static members in other languages, 
    // at runtime those are still instance members of real objects
    // However, on the JVM you can have members of companion objects generated as real static methods 
    // and fields, if you use the @JvmStatic annotation
    // a companion object is initialized when the corresponding class is loaded (resolved), 
    // matching the semantics of a Java static initializer.
    companion object Named {
        fun bar() { println("C's Named Companion") }

        @JvmStatic
        fun baz() {}
    }
}

fun main() {
    val c = C()
    c.a.foo()
    // println(c.b.addition()) // as b's type is Any
    c.doSomething()
    C.Named.bar() // call is on companion
}
