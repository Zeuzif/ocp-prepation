#### Generic classes

Generic classes become useful when the classes used as the type parameter can have absolutely
nothing to do with each other.\
Behind the scenes, the compiler replaces all references to T in Crate with Object. In other
words, after the code compiles, your generics are actually just Object types.\
This process of removing the generics syntax from your code is referred to as `type
erasure`. Type erasure allows your code to be compatible with older versions of Java
that do not contain generics.\
The compiler adds the relevant casts for your code to work with this type of erased
class. For example, you type:
```
Robot r = crate.emptyCrate();
```
And the compiler turns into:
```
Robot r = (Robot) crate.emptyCrate();
```
what we cannot do with generics:\
■ Call the constructor. new T() is not allowed because at runtime it would be new
Object().\
■ Create an array of that static type. This one is the most annoying, but it makes sense
because you’d be creating an array of Objects.\
■ Call instanceof. This is not allowed because at runtime List<Integer> and
List<String> look the same to Java thanks to type erasure.\
■ Use a primitive type as a generic type parameter. This isn’t a big deal because you
can use the wrapper class instead. If you want a type of int, just use Integer.\
■ Create a static variable as a generic type parameter. This is not allowed because the
type is linked to the instance of the class.

A `bounded parameter type` is a generic type that specifies a bound for the generic.

Imagine a situation:
```
public static void main(String[] args) {
    List<String> keywords = new ArrayList<String>();
    keywords.add("Hello");
    printList(keywords); // does not compile
}

public static void printList(List<Object> list) {
    for (Object object : list) {
        System.out.println(object);
    }
}
```
it's seems logical but it's wrong, why? if compiler allow us to do that the code bellow will compile
```
4: List<String> strings = new ArrayList<>();
5: strings.add("Hello");
6: List<Object> objects = strings; // does not compile
7: objects.add(1);
8: System.out.println(numbers.get(1));
```
On line 4, the compiler promises us that only String objects will appear in strings. If
line 6 were to have compiled, line 7 would break that promise by putting an Integer in there
since strings and objects are references to the same object. Good thing that the compiler
prevents this :).

#### Collections

