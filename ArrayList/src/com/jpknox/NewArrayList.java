package com.jpknox;

/**
 * Created by joaok on 28/03/2017.
 */
public class NewArrayList {

    private static final int block_factor = 3;

    private int index;
    private int size;
    private int[] data;

    public NewArrayList() {
        index = 0;
        size = block_factor;
        data = new int[size];
    }

    public NewArrayList(int size) {
        index = 0;
        this.size = size;
        data = new int[size];
    }

    public void add(int newNumber) {
        data[index] = newNumber;
        index++;

        if (index % block_factor == 0) {
//            System.out.printf("Inserting %d, but reached max capacity. Index is %d. Size is %d. Increasing.\n", newNumber, index, size);
            increaseSize();
        }
    }

    private void increaseSize() {
        size += block_factor;
        int[] newData = new int[size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < index; i++) {
            stringBuilder.append(data[i]);
            if (i < index-1) stringBuilder.append(", ");
        }
        stringBuilder.append("}");
        System.out.printf("%s\n", stringBuilder.toString());
    }

    public int find(int key) {
        for (int i = 0; i < index; i++) {
            if (data[i] == key) return key;
        }
        return -1;
    }

    public int remove(int key) {
        for (int finder = 0; finder < index; finder++) {
            if (data[finder] == key) {
                for (int shifter = finder; shifter < index-1; shifter++) {
                    data[shifter] = data[shifter+1];
                }
                index--;
                return key;
            }
        }
        return -1;
    }

    public int getIndex(int key) {
        if (key >= index || key < 0) return -1;

        System.out.printf("Found item %d at index %d\n", data[key], key);
        return data[key];
    }
}
