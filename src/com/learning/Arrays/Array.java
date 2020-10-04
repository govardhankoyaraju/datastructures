package com.learning.Arrays;

public class Array {

    private int[] items;
    private int size;

    public Array(int initialSize) {
        items = new int[initialSize];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {

        //If the array is full, resize it.
        if (items.length == size) {
            //Create a new array (twice the size)
            int[] newItems = new int[size * 2];
            //Copy all the existing items
            for(int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            // Set "Items" to this new Array
            items = newItems;
        }

        // Add the new ITEM at the end.
        items[size++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();

        for(int i = index; i < size; i++)
            items[i] = items[i+1];

        size--;
    }

    public int indexOf(int item) {
        // O(n)
        for (int i = 0; i < size; i++)
            if(items[i] == item)
                return i;

        return -1;
    }

    public int length() {
        return size;
    }
}
