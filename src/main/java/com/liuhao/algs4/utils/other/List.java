package com.liuhao.algs4.utils.other;

public class List<T> {

    public static class Node<E> {
        public E item;
        public Node next;
    }

    public static void main(String[] args) {
        Node<String> first = new Node<String>();
        first.item = "Hello";

        Node<String> second = new Node<String>();
        second.item = "there";

        Node<String> third = new Node<String>();
        third.item = "yoo";

        first.next = second;
        second.next = third;
    }
}
