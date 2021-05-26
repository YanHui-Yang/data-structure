package com.yyh;

/**
 * Author: Tong
 * Date: 2021/5/26
 * Description:
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {
        this.array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return this.array.size();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        this.array.addLast(e);
    }

    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override
    public E getFront() {
        return this.array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < this.array.size(); i++) {
            res.append(this.array.get(i));
            if (i != this.array.size() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
