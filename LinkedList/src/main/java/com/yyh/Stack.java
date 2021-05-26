package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/26
 * Description:
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
