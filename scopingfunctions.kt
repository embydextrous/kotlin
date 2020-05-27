class A {
    var a = 2
    var b = 2

    override fun toString() = "a:$a, b:$b"
}

fun main(args: Array<String>) {
   // Returns context object A
   // Context object caan be referred using `this`
   // It is an extension function 
   val a = A().apply {
        this.a = 32
        this.b = 34
    }
    println(a)

    // Returns result of last step
    // Context object can be referred using `it` or specified name
    // It is an extension function 
    val b = A().let { _a ->
        _a.a = 32
        _a.b = 34
    1
    }
    println(b)

    // Returns result of last step
    // Context object can be referred using `this`
    // It is an extension function 
    val c = A().run {
        this.a = 32
        this.b = 34
        2
    }
    println(c)

    // Returns context object A
    // Context object caan be referred using `it` or given name
    // It is an extension function    
    val d = A().also {
        it.a = 32
        it.b = 34
    }
    println(d)

    val context = A()
    // Returns result of last step
    // There is no context object here.
    // It is not an extension function.
    val e = run {
        context.a = 32
        context.b = 34
        3
    }
    println(e)

    // Returns result of last step
    // Context object can be referred using `this`
    // It is not an extension function so context object needs to be pass explicitly.
    val f = with(context) {
        this.a = 23
        this.b = 32
        4
    }
    println(f)
}
