package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/26
 * Description: 使用链表实现栈
 */
public class LinkedListStack<E> implements Stack<E> {

    private DummyHeadLinkedList<E> list;

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return null;
    }
}
