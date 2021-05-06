package me.wassif.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypes {
    public static void main(String[] args) {
        // legacy code < 1.5
        List words = new ArrayList();
        words.add("Hello");
        words.add("world");
        System.out.println(words); // print list
        words.add(1);
        System.out.println(words.get(2));
        // with generics
        List<String> newWords = new ArrayList<>(); // <> diamond operator
        newWords.add("Hello");
        // newWords.add(1); //does not compile
        //
        List numbers = new ArrayList();
        numbers.add(1);
        // Integer num1 = numbers.get(1); // does not compile
    }
}
