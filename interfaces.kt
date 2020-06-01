interface Named {
    val name: String // abstract property

    fun alias(): String
}

interface Named2 {
    fun alias(): String {
        return "Haha"
    }
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val name get() = "$firstName $lastName"

    override fun alias() = "My name is $name"
}

class A : Person, Named2 {
    override val firstName = "Arjit"
    override val lastName = "Agarwal"

    override fun alias(): String {
        val a = super<Person>.alias()
        val b = super<Named2>.alias()
        println(a)
        println(b)
        return "Oho"
    }
}

interface P {
    fun alias() {}
    fun bar()
}

interface R {
    fun alias() {}
    fun bar() {}
}

class R : P, Q {
    override fun alias() {
        super<P>.alias()
        super<Q>.alias()
    }

    override fun bar() {
        super.bar()
    }
}

fun main() {
    val a = A()
    println(a.firstName)
    println(a.lastName)
    println(a.alias())
}

