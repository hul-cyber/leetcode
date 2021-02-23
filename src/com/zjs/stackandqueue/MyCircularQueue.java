package com.zjs.stackandqueue;

/**
 * @ClassName MyCircularQueue
 * @Description 622. 设计循环队列 题目链接: https://leetcode-cn.com/problems/design-circular-queue/
 * 使用数组实现，循环利用数组
 * @Author hul-cyber
 * @Date 2021/2/23 17:54
 * @Version 1.0
 */
public class MyCircularQueue {

    private int[] array;
    private int front;
    private int rear;
    int size;

    public MyCircularQueue(int k) {
        size = k + 1;
        array = new int[size];
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
