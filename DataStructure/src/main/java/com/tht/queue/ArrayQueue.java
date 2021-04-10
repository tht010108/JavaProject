package com.tht.queue;

/**
 * @ClassName : com.tht.queue.ArrayQueue
 * @Description : 数组队列(环形)
 * Author : space
 * CreatedDate 2021-04-10 22:41:25
 */

public class ArrayQueue {
    private int maxSize; //表示最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //模拟队列

    public ArrayQueue(int maxSize){
        maxSize += 1; //空出一个位置做为约定
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0; //指向队列头部
        rear = 0;  //指向队列尾部后一个位置,空出一个位置做为约定
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 入队列
     * @param val
     */
    public void addQuere(int val){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear] = val;
        rear = (rear+1) % maxSize;  //因为为环形队列，所以要考虑取模。
    }

    /**
     * 出队列
     * @return
     */
    public int getQuere(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;    //因为为环形队列，所以也要考虑取模。
        return val;
    }

    /**
     * 获取队列长度
     * @return
     */
    public int length(){
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 打印队列数据
     */
    public void printQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + length(); i++){
            System.out.printf("%d -> arr[%d]: %d\n",i - front + 1,i % maxSize,arr[i % maxSize]);
        }
    }

    /**
     * 查看头元素
     * @return
     */
    public int headQuere(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
