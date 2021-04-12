package com.tht.linkedlist;

/**
 * @ClassName : com.tht.linkedlist.CircleSingleLinkedList
 * @Description : 环形单链表
 * Author : space
 * CreatedDate 2021-04-12 11:25:41
 */
public class CircleSingleLinkedList {
    private SingleLinkedListNode first;

    /**
     * 无序添加
     * @param node
     */
    public void add(SingleLinkedListNode node){
        if(first == null){
            first = node;
            node.setNext(first);
            return;
        }
        //定义一个变量指向头节点，用于辅助遍历
        SingleLinkedListNode temp = first;
        //找到链表最后
        while (!temp.getNext().equals(first)){
            //后移
            temp = temp.getNext();
        }
        node.setNext(first);
        temp.setNext(node);

    }

    public void print(){
        if (first == null){
            return;
        }
        SingleLinkedListNode temp = first;  //用于辅助遍历
        //遍历，如果temp等于空或temp等于first节点就退出
        do{
            System.out.println(temp);
            temp = temp.getNext();
        }while (temp != null && !temp.equals(first));
    }

    /**
     * 约瑟夫问题
     * @param start 从第几个开始
     * @param step 步数
     */
    public void josephu(int start,int step){
        if(first == null || start < 1 || step < 1){
            return;
        }
        //first移动到开始位置
        for (int i = 0; i < start - 1; i++){
            first = first.getNext();
        }
        SingleLinkedListNode tail = first;  //指向最后一个节点
        //找到最后一个节点
        while (!tail.getNext().equals(first)){
            tail = tail.getNext();
        }
        //开始出圈
        //当只有一个节点，即tail == first时，退出循环
        while (tail != first){
            for (int i = 0; i < step - 1; i++){
                first = first.getNext();
                tail = tail.getNext();
            }
            System.out.println(first+"-------------出圈");
            first = first.getNext();
            tail.setNext(first);
        }
        System.out.println(first);
    }
}
