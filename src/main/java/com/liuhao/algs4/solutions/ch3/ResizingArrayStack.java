package com.liuhao.algs4.solutions.ch3;

import java.util.Iterator;

@SuppressWarnings("WeakerAccess")
public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        this.elements = (T[]) new Object[1];
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
        if (size == elements.length) {
            this.resize(2 * this.elements.length);
            System.out.printf("resize from %d to %d\n", size, this.elements.length);
        }
        this.elements[size] = element;
        size++;
    }

    public T pop() {
        T result = this.elements[--size];
        this.elements[size] = null;
        if (size > 0 && size == this.elements.length / 4) {
            this.resize(this.elements.length / 2);
        }
        return result;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public void resize(int size) {
        T[] temp = (T[]) new Object[size];
        System.arraycopy(this.elements, 0, temp, 0, this.size);
        this.elements = temp;
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> fixedCapacityStack = new ResizingArrayStack<String>();
        for (int i = 0; i < 100; i++) {
            fixedCapacityStack.push("巫");
            fixedCapacityStack.push("梦");
            fixedCapacityStack.push("笛");
        }

        for (String p : fixedCapacityStack) {
            System.out.printf("deQueue got %s, %d left\n", p, fixedCapacityStack.size());
        }
        System.out.printf("deQueue got %s, %d left\n", fixedCapacityStack.pop(), fixedCapacityStack.size());
        System.out.printf("deQueue got %s, %d left\n", fixedCapacityStack.pop(), fixedCapacityStack.size());
        System.out.printf("deQueue got %s, %d left\n", fixedCapacityStack.pop(), fixedCapacityStack.size());
    }
}
