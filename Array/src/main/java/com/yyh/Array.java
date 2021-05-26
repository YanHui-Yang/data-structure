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
        return size;
    }

    // 判断数组是否为null
    public boolean isEmpty() {
        return this.size == 0;
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

    // 获取索引位置的元素
    public E get(int i) {
        return this.data[i];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 修改在index索引的元素
    public void set(int index, E e) {
        this.data[index] = e;
    }

    // 查找数组是否包含元素e
    public boolean contains(E e) {
        if (this.find(e) != -1)
            return true;
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < this.size; i++)
            if (this.data[i].equals(e))
                return i;
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for (int i = index + 1; i < this.size; i++)
            data[i - 1] = data[i];
        data[this.size] = null;
        this.size--;
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
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
