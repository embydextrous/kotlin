/* Provides hash code, equals, toString, getters and setters (for vars), copy(), componentN() functions */
/* primary constructors have vals and vars and in case of JVM they should provide default values */
/* primary constructors must have one member */
/* Data classes cannot be abstract, sealed, open or inner */
/* Data classes can only implement interfaces */
data class DataUser(val id: Int, val firstName: String, val lastname: String) {
    var gender = "MALE" // this property does not take part in equals()/hashcode()/toString()/copy()
}

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
    d.gender = "FEMALE"
    run {
        // prints DataUser(id=1, firstName=Arjit, lastname=Agarwal)
        println(c)
        println(d)
        // prints true as we have equals() implementation
        println("Are genders same? ${c.gender == d.gender}") // false
        println(c == d) // still true
        println("${c.component2()} ${c.component3()}")
    }
}
