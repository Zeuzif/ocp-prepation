#### designing an interface 
(code)

#### casting rules
*from subclass to superclass does not need explicit cast
*from superclass to subclass need explicit cast
*the compiler does not allow cast of unrelated objects
*Even when the code compiles without issue, an exception may be thrown at runtime if
the object being cast is not actually an instance of that class

#### design patterns
A design pattern is an established general solution to a commonly occurring software
development problem.

The immutable object pattern is a creational pattern based on the idea of
creating objects whose state does not change after they are created and can be easily shared
across multiple classes

for making a class immutable:
1. Use a constructor to set all properties of the object
2. Mark all instance vars private final
3. Don't define any setter method
4. Don't allow referenced mutable object to be accessed or modified directly
5. Prevent methods from being overriden

The problem of a constructor growing too large actually has a name, referred to as the
telescoping constructor anti‐pattern.

