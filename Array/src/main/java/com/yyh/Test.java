package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/21
 * Description: 测试
 */
public class Test {

    public static void main(String[] args) {
        Array<String> arr = new Array<>();
        arr.add(0, "hh");
        arr.add(1, "h2h");
        arr.addFirst("123");
        arr.addLast("you");
        System.out.println(arr);
    }
}
