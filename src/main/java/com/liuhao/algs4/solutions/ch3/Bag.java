package com.liuhao.algs4.solutions.ch3;

import java.util.Iterator;

public class Bag<T> implements Iterable {

    private Node<T> top;
    private int size;

    public Bag() {
        this.size = 0;
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private Node<T> curNode = top;

        public boolean hasNext() {
            return curNode != null;
        }

        public T next() {
            T value = curNode.value;
            curNode = curNode.next;
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    public void add(T element) {
        Node<T> newTop = new Node<T>(element);
        newTop.next = this.top;
        this.top = newTop;
        size++;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        for (int i = 0; i < 100; i++) {
            bag.add("巫");
            bag.add("梦");
            bag.add("笛");
        }

        for (Object p : bag) {
            System.out.printf("iterator got %s\n", p.toString());
        }
    }
}
