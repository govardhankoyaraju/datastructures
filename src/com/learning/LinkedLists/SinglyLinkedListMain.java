package com.learning.LinkedLists;

import java.util.Arrays;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        var arr = list.toArray();
        System.out.println(Arrays.toString(arr));

    }
}
