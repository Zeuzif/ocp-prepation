#### Vars access using lambda
Lambda expression can access static var, instance var, method param, and effectively final local variable.
#### Built-in functional interfaces
- Supplier -> get()
- Consumer -> accept()
- Function -> apply()
- Predicate -> test()

#### Using streams
stream is a sequence of data.
We can’t create an infinite list, though, which makes streams more powerful

`findAny()` is an exemple of terminal operation but not reduction, the reason is that return a value based on the stream but do not reduce the entire stream into value. 
