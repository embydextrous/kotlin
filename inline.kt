// Experimental feature since Kotlin
// Class is not generated so code is inline in Java generation.
inline class Password(val s: String) { // can have only one member in constructor as val
    val length: Int
        get() = s.length // can have properties that resolves to functions

    // inline classes cannot have init blocks

    fun print() {
        println(s)
    }
}

typealias Str = String // no new type
inline class Strt(val s: String) // new type

fun main() {
    val a: Password = Password("ArjitAga")
    a.print()
    println(a.length)

    val s1: Str = "Arjit"
    // val s2: Strt = "Arjit" // illegal 
}
