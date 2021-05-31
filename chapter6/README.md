#### Exceptions
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

try-catch wit resource:\
a try-with-resources statement is still allowed to have catch and/
or finally blocks. They are run in addition to the implicit one. The implicit finally block
runs before any programmer-coded ones.\
an overriding method is allowed to declare more specific exceptions than the parent or even none at all.

Suppressed Exceptions:\
When multiple exceptions are thrown, all but
the first are called suppressed exceptions. The idea is that Java treats the first exception as
the primary one and tacks on any that come up while automatically closing

#### Assertions:
An assertion is a Boolean expression that you place at a point in your code where you
expect something to be true.\
an assertion is a shorter/better way of writing the
following:
```
if (!boolean_expression) throw new AssertionError();
```
how assertions are used: 
- Internal Invariants: You assert that a value is within a certain constraint.
- Class Invariants You assert the validity of an object’s state. Class invariants are typically
private methods within the class that return a boolean
- Control Flow Invariants You assert that a line of code you assume is unreachable is never
reached
- Preconditions You assert that certain conditions are met before a method is invoked.
- Post Conditions You assert that certain conditions are met after a method executes
successfully.



