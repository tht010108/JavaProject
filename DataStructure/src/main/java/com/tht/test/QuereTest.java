package com.tht.test;

import com.tht.queue.ArrayQueue;

/**
 * @ClassName : com.tht.test.QuereTest
 * @Description : 数组队列(环形)测试类
 * Author : space
 * CreatedDate 2021-04-10 22:41:55
 */
public class QuereTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQuere(1);
        arrayQueue.addQuere(2);
        arrayQueue.addQuere(3);
        System.out.println("出队列："+arrayQueue.getQuere());
        System.out.println("出队列："+arrayQueue.getQuere());
        arrayQueue.addQuere(4);
        arrayQueue.addQuere(5);
        arrayQueue.printQueue();
    }
}
