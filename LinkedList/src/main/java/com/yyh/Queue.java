package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/26
 * Description: 使用链表实现队列
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
