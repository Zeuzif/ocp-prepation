package me.wassif.generics;

class Crate<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    // the formal type <T> if we omit formal type this does not compile
    public static <T> T identity(T t) {
        return t;
    }
}

public class Main {
    public static void main(String[] args) {
        // we can invoke static method like this
        Crate.identity("world");
        // or explicitly make it obvious
        Crate.<String>identity("hello");
    }
}
