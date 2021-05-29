### Exceptions
- Java checks the catch blocks in the order in which they appear. It is illegal to declare
a subclass exception in a catch block that is lower down in the list than a superclass
exception because it will be unreachable code.
- Java will not allow you to declare a catch block for a checked exception type
that cannot potentially be thrown by the try clause body. This is again to avoid
unreachable code

Points to remember: 
- there can be only one exception variable per catch block
- The more general superclasses must be caught after their subclasses
- You can’t list the same exception type more than once in the same try statement
- any runtime exception may be caught. However, only checked exceptions that have the potential to be thrown are allowed to be caught.