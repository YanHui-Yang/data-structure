package com.yyh;

import org.w3c.dom.Node;

/**
 * Author: Tong
 * Date: 2021/5/26
 * Description: 手写虚拟头节点链表
 */
public class DummyHeadLinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public DummyHeadLinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return this.size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        this.size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }
}
