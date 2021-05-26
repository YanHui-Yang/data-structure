package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/26
 * Description: 测试链表
 */
public class Test {

    public static void main(String[] args) {
        DummyHeadLinkedList<Integer> linkedList = new DummyHeadLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
    }
}
