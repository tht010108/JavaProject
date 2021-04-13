package com.tht.stack;

/**
 * @ClassName : com.tht.stack.ArrayStack
 * @Description : 数组模拟栈
 * Author : space
 * CreatedDate 2021-04-13 09:13:35
 */
public class ArrayStack {
    /** 栈的大小 */
    private int maxSize;
    /** 表示栈，存放数据 */
    private int[] stack;
    /** 栈顶 */
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];

    }

    /**
     * 判断是否栈满
     * @return
     */
    public boolean isFull(){
        return top == maxSize-1;
    }
    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    /**
     *
     */
    public void print(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--){
            System.out.print(stack[i]+"\t");
        }
        System.out.println();
    }
}
