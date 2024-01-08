package com.liuhao.algs4.solutions.ch3;

public class Node<E> {
    public E value;
    public Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}