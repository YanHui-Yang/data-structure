package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/21
 * Description: 手写链表
 */
public class LinkedList<E> {

    private class Node {

        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node head;

    public LinkedList() {
        this.size = 0;
        this.head = head;
    }

    // 获取链表中的元素个数
    public int size() {
        return this.size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head; // head变成node后面的节点
//        head = node;  // node变成head
        head = new Node(e, head);
        this.size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        if (index == 0)
            addFirst(e);
        else {
            Node prev = head;   // 存放头部引用
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;   // 遍历到index前一个节点
//            Node node = new Node(e);
//            node.next = prev.next;  // prev.nex=index节点，index节点变成node的下一个节点
//            prev.next = node;   // node节点变成index节点

            prev.next = new Node(e, prev.next);
            this.size++;
        }

    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(this.size, e);
    }
}