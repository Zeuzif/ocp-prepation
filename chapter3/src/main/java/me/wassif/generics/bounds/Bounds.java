package me.wassif.generics.bounds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bounds {
    public static void main(String[] args) {
        List<? super IOException> exceptions = new ArrayList<Exception>();
        // exceptions.add(new Exception()); // Does not compile
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }
}
