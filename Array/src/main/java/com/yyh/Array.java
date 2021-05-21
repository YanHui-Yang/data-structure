package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/21
 * Description: 动态数组
 */
public class Array<E> {

    private int size;   //数组长度
    private E[] data;     //数据

    // 使用无参时则创建一个长度为10的数组
    public Array() {
        this(10);
    }

    // 数组初始化
    public Array(int capacity) {
        this.size = 0;
        this.data = (E[]) new Object[capacity];
    }

    // 获取数组容量
    public int size() {
        return data.length;
    }

    // 判断数组是否为null
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // 在index位置插入元素
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        for (int i = this.size - 1; i >= index; i--)
            this.data[i + 1] = this.data[i];

        this.data[index] = e;
        this.size++;
    }

    // 在尾部插入一个元素
    public void addLast(E e) {
        this.add(this.size, e);
    }

    // 在头部插入一个元素
    public void addFirst(E e) {
        this.add(0, e);
    }


    // 遍历数组
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("数组：[");
        for (int i = 0; i < this.size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

}
