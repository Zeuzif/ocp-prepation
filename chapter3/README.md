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