package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/26
 * Description: 测试ArrayStack
 */
public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
