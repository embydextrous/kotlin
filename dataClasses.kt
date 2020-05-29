/* Provides hash code, equals, toString, getters and setters (for vars), copy(), componentN() functions */
data class DataUser(val id: Int, val firstName: String, val lastname: String)

class SimpleUser(val id: Int, val firstName: String, val lastname: String)

fun main() {
    val a = SimpleUser(1, "Arjit", "Agarwal")
    val b = SimpleUser(1, "Arjit", "Agarwal")
    run {
        // prints address
        println(a)
        println(b)
        // prints false
        println(a == b)
        //println(a.component2() + a.component3()) This will give compilation error.
    }

    val c = DataUser(1, "Arjit", "Agarwal")
    val d = DataUser(1, "Arjit", "Agarwal")
    run {
        // prints DataUser(id=1, firstName=Arjit, lastname=Agarwal)
        println(c)
        println(d)
        // prints true as we have equals() implementation
        println(c == d)
        println("${c.component2()} ${c.component3()}")
    }
}
