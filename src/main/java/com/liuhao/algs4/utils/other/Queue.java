package com.liuhao.algs4.utils.other;

import java.util.Iterator;

@SuppressWarnings("WeakerAccess")
public class Queue<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;

    private int size;

    public Queue() {
        this.size = 0;
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private Node<T> curNode = first;

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

    /**
     * 从队列尾部加新元素
     *
     * @param element
     */
    public void enQueue(T element) {
        System.out.printf("enQueue %d %s\n", size, element.toString());
        Node<T> oldLast = this.last;
        this.last = new Node<T>(element, null);
        if (this.isEmpty()) {
            this.first = this.last;
        } else {
            oldLast.next = this.last;
        }
        size++;
    }

    /**
     * 从队列头部取老元素
     *
     * @return
     */
    public T deQueue() {
        Node<T> result = this.first;
        this.first = this.first.next;
        if (this.isEmpty()) {
            this.last = null;
        }
        size--;
        return result.value;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        Queue<String> stack = new Queue<String>();
        for (int i = 0; i < 100; i++) {
            stack.enQueue("巫");
            stack.enQueue("梦");
            stack.enQueue("笛");
        }

        for (String p : stack) {
            System.out.printf("deQueue got %s, %d left\n", p, stack.size());
        }
        for (int i = 0; i < 300; i++) {
            System.out.printf("deQueue got %s, %d left\n", stack.deQueue(), stack.size());
        }
    }
}
