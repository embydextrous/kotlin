// Only produces T `out` indicates to the compiler that this only produces T and not consumes it.
// C<Base> can safely be a supertype of C<Derived> if `out` is mentioned.
// `out` is called variance annotation.
// PECS(producer extends consumer super) in JAVA, POCI(producer out consumer in) in kotlin
class Generics<out T>(val t: T) {
    fun get(): T = t
}

class Generics2<T>() {
    //fun get(): T = t // illegal won't compile
    fun print(t: T) {
        println(t)
    }
}

fun main() {
    val g: Generics<Any> = Generics<String>("Arjit Agarwal") // This doesn't work in Java
    val g2: Generics2<Any> = Generics2<Any>()
    g2.print("Any()")
    println(g.get())

    val a1 = arrayOf<Int> (1, 2, 3)
    val a2 = Array<Any>(3) { "" }
    // copy(a1, a2) illegal
    _copy(a1, a2) // works due to type projection
    println(a2[0])
}

fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

fun _copy(from: Array<out Any>, to: Array<Any>) {
    // only methods that produce Any can be called on from like get, set can't be called.
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

/*
    You can project a type with in as well:

    fun fill(dest: Array<in String>, value: String) { ... }

    Array<in String> corresponds to Java's Array<? super String>, i.e. you can pass an array of CharSequence 
    or an array of Object to the fill() function.
 */

 /*
    Star Projections
    
    Kotlin provides so called star-projection syntax for this:

    For Foo<out T : TUpper>, where T is a covariant type parameter with the upper bound TUpper, Foo<*> 
    is equivalent to Foo<out TUpper>. It means that when the T is unknown you can safely read values of 
    TUpper from Foo<*>.
    For Foo<in T>, where T is a contravariant type parameter, Foo<*> is equivalent to Foo<in Nothing>. 
    It means there is nothing you can write to Foo<*> in a safe way when T is unknown.
    For Foo<T : TUpper>, where T is an invariant type parameter with the upper bound TUpper, Foo<*> is 
    equivalent to Foo<out TUpper> for reading values and to Foo<in Nothing> for writing values.

    If a generic type has several type parameters each of them can be projected independently. For example,
    if the type is declared as interface Function<in T, out U> we can imagine the following star-projections:

    Function<*, String> means Function<in Nothing, String>;
    Function<Int, *> means Function<Int, out Any?>;
    Function<*, *> means Function<in Nothing, out Any?>.

    Note: star-projections are very much like Java's raw types, but safe.
  */

  /*
    Generic Funstions
    Not only classes can have type parameters. Functions can, too. Type parameters are placed before the name of the function:

    fun <T> singletonList(item: T): List<T> {
        // ...
    }

    fun <T> T.basicToString(): String {  // extension function
    // ...
    }

    To call a generic function, specify the type arguments at the call site after the name of the function:

    val l = singletonList<Int>(1)

    Type arguments can be omitted if they can be inferred from the context, so the following example works as well:

    val l = singletonList(1)
   */

   /* 
    Type Erasures
    The type safety checks that Kotlin performs for generic declaration usages are only done at compile time. 
    At runtime, the instances of generic types do not hold any information about their actual type arguments. 
    The type information is said to be erased. For example, the instances of Foo<Bar> and Foo<Baz?> are erased 
    to just Foo<*>.

    Therefore, there is no general way to check whether an instance of a generic type was created with certain 
    type arguments at runtime, and the compiler prohibits such is-checks.

    Type casts to generic types with concrete type arguments, e.g. foo as List<String>, cannot be checked 
    at runtime. These unchecked casts can be used when type safety is implied by the high-level program 
    logic but cannot be inferred directly by the compiler. The compiler issues a warning on unchecked casts, 
    and at runtime, only the non-generic part is checked (equivalent to foo as List<*>).
    */
