Java 5 was released and the Concurrency API was introduced in the
`java.util.concurrent` package.\
Thread is the smallest unit of execution that can be scheduled by the operating system. A process
is a group of associated threads that execute in the same, shared environment. It follows,
then, that a single-threaded process is one that contains exactly one thread, whereas a
multi-threaded process is one that contains one or more threads.\
A task is a single unit of work performed by a thread.\
A thread can complete multiple independent tasks but only one task at a time.\
*Daemon thread* is one that will not prevent the JVM from exiting when the program finishes

Be careful about cases where a Thread or Runnable is created but no
`start()` method is called. While the following code snippets will compile, none will
actually execute a task on a separate processing thread. Instead, the thread that made the
call will be used to execute the task, causing the thread to wait until each `run()` method is
complete before moving on to the next line
```
new PrintData().run();
(new Thread(new PrintData())).run();
(new ReadInventoryThread()).run();
```
How to resolve Ambiguous Lambda Expressions: Callable vs. Supplier\
we can add an explicit cast.

Thread Pool:
| method | return type|
|--------|------------|
|newSingleThreadExecutor()| ExecutorService|
|newSingleThreadScheduledExecutor()| ScheduledExecutorService|
|newCachedThreadPool()|ExecutorService|
|newFixedThreadPool(int nThreads)|ExecutorService|
|newScheduledThreadPool(int nThreads)|ScheduledExecutorService|