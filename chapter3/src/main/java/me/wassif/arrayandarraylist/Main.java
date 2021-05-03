package me.wassif.arrayandarraylist;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] array = {
                "hello", "world"
        };
        List<String> list = Arrays.asList(array); // fixed size list
        list.set(1, "test");
        printArray(array); // [hello, test]
        array[0] = "new";
        System.out.println(list); // [new, test]
        String[] array2 = (String[]) list.toArray();
        list.remove(0); // throws UnsupportedOperationException
    }

    private static void printArray(String[] array) {
        System.out.printf("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1)
                System.out.printf("%s, ", array[i]);
            else
                System.out.printf("%s", array[i]);
        }
        System.out.printf("]\n");
    }
}
