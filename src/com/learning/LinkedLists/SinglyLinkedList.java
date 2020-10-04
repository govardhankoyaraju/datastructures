package com.learning.LinkedLists;


import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node (T value) {
            this.value = value;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void addLast(T item) {
        var node = new Node<T>(item);

        if(isFirstEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(T item) {
        Node<T> node = new Node<T>(item);

        if(isFirstEmpty())
            first = last= node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isFirstEmpty() {
        return first == null;
    }

    public int indexOf(Object item) {
        int index = 0;
        Node<T> current = first;
        while(current != null) {
            if(current.value == item)
                return index;

            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(Object item) {
        return indexOf(item) >= 0;
    }

    public void removeFirst() {
        if (isFirstEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            Node<T> second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isFirstEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            Node<T> previousNode = getPrevious(last);
            last = previousNode;
            last.next = null;
        }

        size--;
    }

    private Node getPrevious(Node<T> node) {
        Node<T> current = first;
        while (current != null) {
            if (current.next == node)
                return current;

            current = current.next;
        }
        return null;
    }

    // O(1)
    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isFirstEmpty()) return;

        Node<T> previous = first;
        Node<T> current = first.next;
        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

}
