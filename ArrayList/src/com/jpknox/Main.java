package com.jpknox;

public class Main {

    public static void main(String[] args) {
	    NewArrayList newArrayList = new NewArrayList();

        int quant = 100;
        for(int i = 0; i <= quant; i++) {
            newArrayList.add(i);
        }


        assert(quant == newArrayList.getIndex(quant));

    }
}
