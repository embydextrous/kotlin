class LateInit(val sum: Int)

class A {
    var a: Int = 1 // Mutable Property
    val b: Int = 2 // Immutable Property
    val c = 3 // Implicit type referred as Int
    // custom getters and setters
    var d: Int = 0
        get() = "ABC".length
        set(value) { field = value } // field is backing field and only accessible inside get or set
    var e: Int = 0
        private set // only getter is exposed

    // Backing Property
    private var _table: Int? = null
    public var table: Int = 0
        get() {
            if (_table == null) {
                _table = 0 // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
    }

    val l: Int by lazy { a + b + c } // only initialized once, thread-safe

    lateinit var i: LateInit

    companion object {
        // Consts can be declared only inside objects
        const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
        // Can't be a const and can be declared as member
        val s = A::class.java.simpleName
    }
}

fun main() {
    val a = A()
    try {
        println("This will throw error ${a.i.sum}") // Won't be printed
    }
    catch(e: Exception) {
        println(e) // kotlin.UninitializedPropertyAccessException: lateinit property i has not been initialized
    }

    a.i = LateInit(a.a + a.b + a.c)
    println("This will be printed ${a.i.sum}")

    println("${a.a}, ${a.b}, ${a.c}, ${a.l}") // prints 1, 2, 3, 6
    a.a = 5
    println("${a.a}, ${a.b}, ${a.c}, ${a.l}") // prints 1, 2, 3, 6 { l won't be recomputed }
}
