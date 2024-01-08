package com.liuhao.algs4.solutions.ch3;

import java.util.Iterator;

@SuppressWarnings("WeakerAccess")
public class Stack<T> implements Iterable<T> {

    private Node<T> top;

    private int size;

    public Stack() {
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

    public void push(T element) {
        Node<T> newTop = new Node<T>(element);
        newTop.next = this.top;
        this.top = newTop;
        size++;
    }

    public T pop() {
        Node<T> result = this.top;
        this.top = this.top.next;
        size--;
        return result.value;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < 100; i++) {
            stack.push("巫");
            stack.push("梦");
            stack.push("笛");
        }

        for (String p : stack) {
            System.out.printf("deQueue got %s, %d left\n", p, stack.size());
        }
        System.out.printf("deQueue got %s, %d left\n", stack.pop(), stack.size());
        System.out.printf("deQueue got %s, %d left\n", stack.pop(), stack.size());
        System.out.printf("deQueue got %s, %d left\n", stack.pop(), stack.size());
    }
}
