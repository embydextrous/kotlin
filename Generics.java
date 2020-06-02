import java.util.ArrayList;
import java.util.List;

public class Generics {
    private static List<String> l1 = new ArrayList<>();
    public static void main(String[] args) {
        // foo(l1); illegal as List<String> is not a subtype of List<Object> invariants
        bar(l1); // legal List<String> is a subtype of List<? extends Object> called as covariant

        //
        // Generics2<Object> g = new Generics2<String>("Arjit Agarwal"); // Illegal due to types
        Generics2<String> g2 = new Generics2<String>("Arjit Agarwal"); // legal
    }

    public static void foo(List<Object> l1) {
        l1.add(2); // legal
    }

    public static void baz(List<? super String> l1) {
        l1.add("Arjit"); // You can call add(String) or set(String)
        Object o = l1.get(0); // returns object
    }

    public static void bar(List<? extends Object> l1) {
        // <? extends Object> meand you can safely read Object from l1 but 
        // l1.add(2); // writes won't work here

        // The key to understanding why this trick works is rather simple: 
        // if you can only take items from a collection, then using a 
        // collection of Strings and reading Objects from it is fine. 
        // Conversely, if you can only put items into the collection, 
        // it's OK to take a collection of Objects and put Strings into it: 
        // in Java we have List<? super String> a supertype of List<Object>.

        /*
        The latter is called contravariance, and you can only call methods that take String as an argument
        on List<? super String> (e.g., you can call add(String) or set(int, String)), while if you call
        something that returns T in List<T>, you don't get a String, but an Object.

        Joshua Bloch calls those objects you only read from Producers, and those you only write to Consumers.
        He recommends: "For maximum flexibility, use wildcard types on input parameters that represent 
        producers or consumers", and proposes the following mnemonic:

        PECS stands for Producer-Extends, Consumer-Super.

        NOTE: if you use a producer-object, say, List<? extends Foo>, you are not allowed to call add() 
        or set() on this object, but this does not mean that this object is immutable: for example, 
        nothing prevents you from calling clear() to remove all items from the list, since clear() 
        does not take any parameters at all. The only thing guaranteed by wildcards
        (or other types of variance) is type safety. Immutability is a completely different story.
        */
    }
}

// only produces T, see Kotlin version
class Generics2<T> {
    private T t;

    Generics2(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}
