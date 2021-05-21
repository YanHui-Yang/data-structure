package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/21
 * Description: 测试
 */
public class Test {

    public static void main(String[] args) {
        Array<String> arr = new Array<>();
        arr.add(0, "love");
        arr.add(1, "java");
        arr.addFirst("i");
        arr.addLast("!");
        arr.remove(3);
        System.out.println(arr);
    }
}
