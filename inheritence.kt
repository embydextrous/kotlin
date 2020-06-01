open class A {
    fun foo() {}
    open fun bar() {}
}

class B : A() {
    // override fun foo() {} /* f'foo' in 'A' is final and cannot be overridden */
    override fun bar() {} // legal
    //fun foo() {} /* 'foo' hides member of supertype 'A' and needs 'override' modifier */
    //fun bar() {} /* 'bar' hides member of supertype 'A' and needs 'override' modifier */
}

// class C : B() /* this type is final, so it cannot be inherited from */

open class D : A() {
    /* final */ override fun bar() {} // legal
}

class E : D() {
    override fun bar() {} // override in D makes bar open by default. To prevent overriding, mark it final.
}

interface Shape {
    val vertexCount: Int
}

class Rectangle(override val vertexCount: Int = 4) : Shape // Always has 4 vertices

class Polygon : Shape {
    // You can override val with var but not vice versa
    override var vertexCount: Int = 0  // Can be set to any number later
}

/*
    By the time of the base class constructor execution, the properties declared or overridden 
    in the derived class are not yet initialized. If any of those properties are used in the base 
    class initialization logic (either directly or indirectly, through another overridden open member 
    implementation), it may lead to incorrect behavior or a runtime failure. When designing a base class, 
    you should therefore avoid using open members in the constructors, property initializers, and init blocks.
 */
open class Base(val name: String) {

    init { println("Initializing Base") }

    open val size: Int = 
        name.length.also { println("Initializing size in Base: $it") }
}

class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

fun main() {
    val a = Derived("Arjit", "Agarwal")
}
