package org.example;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 5, 3, 4};
        int length = array.length - 1,
            index = Arrays.binarySearch(array, Collections.max(Arrays.asList(array)));
        Integer[] result = Arrays.copyOf(array, length);
        if (index < length) result[index] = array[length];
        System.out.println("array : " + Arrays.toString(array));
        System.out.println("result : " + Arrays.toString(result));
    }
}