package com.liuhao.algs4.utils.other;

import java.util.Iterator;

@SuppressWarnings("WeakerAccess")
public class FixedCapacityStack<T> implements Iterable<T> {

    private T[] elements;
    private int size;

    public FixedCapacityStack(int size) {
        this.elements = (T[]) new Object[size];
        this.size = 0;
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int n = size;

        public boolean hasNext() {
            return n > 0;
        }

        public T next() {
            return elements[--n];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    public void push(T element) {
        if (size < elements.length) {
            this.elements[size] = element;
            size++;
        }
    }

    public T pop() {
        T result = this.elements[--size];
        this.elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<String>(3);
        fixedCapacityStack.push("巫");
        fixedCapacityStack.push("梦");
        fixedCapacityStack.push("笛");

        for (String p : fixedCapacityStack) {
            System.out.printf("deQueue got %s, %d left\n", p, fixedCapacityStack.size());
        }
        System.out.printf("deQueue got %s, %d left\n", fixedCapacityStack.pop(), fixedCapacityStack.size());
        System.out.printf("deQueue got %s, %d left\n", fixedCapacityStack.pop(), fixedCapacityStack.size());
        System.out.printf("deQueue got %s, %d left\n", fixedCapacityStack.pop(), fixedCapacityStack.size());


        String 巫梦笛 = "老婆";
        System.out.println(巫梦笛);
    }
}
