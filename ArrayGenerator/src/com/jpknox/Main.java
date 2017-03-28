package com.jpknox;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] arr;
        arr = arrayGenerator.generateInt(100, 0);
	    System.out.println(display(arr));
        arr = arrayGenerator.generateInt(0, 100);
        System.out.println(display(arr));

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
    }

    private static String display(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        for (int index = 0; index < array.length; index++) {
            stringBuilder.append(array[index]);
            if (index < array.length-1) stringBuilder.append(", ");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
