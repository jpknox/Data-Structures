package com.jpknox;

import java.util.Random;

/**
 * Created by jpknox on 23/03/17.
 */
public class ArrayGenerator {

    public int[] generateInt(int from, int to) {
        int max, min, size, index;
        max = Math.max(from, to);
        min = Math.min(from, to);
        size = max - min + 1;
        int[] array = new int[size];;
        index = 0;

        if (from < to) {
            while (index < size) {
                array[index] = index + min;
                index++;
            }
        } else {
            while (index < size) {
                array[index] = (min + max) - (index + min);
                index++;
            }
        }


        return array;
    }

    public int[] generateInt(int size) {
        int[] array = new int[size];
        int pos = 0;
        Random rand = new Random();
        while (pos < (size - 1)) {
            array[pos] = rand.nextInt(100);
            pos++;
        }
        return array;
    }

    int[] copyArray(int[] unsorted) {
        int length = unsorted.length;
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = unsorted[i];
        }
        return copy;
    }
}
