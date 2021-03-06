#### access modifiers 

| Can access   | If that member is private? | If that member has default (package private) access? | If that member is protected? | If that member is public? |
|-----------------------|-------------------|---------------|------------|-----------|
| Member in the same class | yes  | yes | yes | yes |
| Member in another class in the same package | no | yes | yes | yes |
| Member in a superclass in a different package | no | no | yes | yes |
| Method/field in a class (that is not a superclass) in a different package | no | no | no | yes |

#### overloading and overriding

When multiple overloaded methods are present, Java looks for the closest match first. It
tries to find the following:\
■ Exact match by type\
■ Matching a superclass type\
■ Converting to a larger primitive type\
■ Converting to an autoboxed type\
■ Varargs

For overriding, the overridden method has a few rules:\
■ The access modifier must be the same or more accessible.\
■ The return type must be the same or a more restrictive type, also known as covariant
return types.\
■ If any checked exceptions are thrown, only the same exceptions or subclasses of those
exceptions are allowed to be thrown.