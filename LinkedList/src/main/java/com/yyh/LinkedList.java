package com.yyh;

public class LinkedList<E> {
    // 初始化一个节点类
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 获取链表中元素的个数
    public int size() {
        return this.size;
    }

    // 是否为null
    public boolean isEmpty() {
        return size == 0;
    }

    // 向链表插入新的元素
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = this.head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    // 向链表索引index插入元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            // 遍历到第index的前一个元素
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            // 进行插入操作
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);
            size++;
        }
    }
}
