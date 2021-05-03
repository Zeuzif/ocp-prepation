package me.wassif.arrayandarraylist.sortsearch;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        // sort and search
        int[] numbers = {
                1, 3, 5, 9, 7
        };
        Arrays.sort(numbers);
        printArray(numbers);
        System.out.println(Arrays.binarySearch(numbers, 3));
        System.out.println(Arrays.binarySearch(numbers, 6)); // -(1 + index)
                                                             // index : when it
                                                             // will be inserted
    }

    private static void printArray(int[] array) {
        System.out.printf("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1)
                System.out.printf("%d, ", array[i]);
            else
                System.out.printf("%d", array[i]);
        }
        System.out.printf("]\n");
    }
}
