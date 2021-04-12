package com.tht.linkedlist;

import lombok.Getter;
import lombok.ToString;

/**
 * @ClassName : com.tht.linkedlist.DoubleLinkedList
 * @Description : 双向链表类
 * Author : space
 * CreatedDate 2021-04-12 09:27:29
 */
@Getter
@ToString
public class DoubleLinkedList {
    /**
     * 头节点，不存放具体数据
     */
    private DoubleLinkedListNode head;
    /**
     * 尾节点
     */
    private DoubleLinkedListNode tail;
    /**
     * 是否排序
     */
    private boolean isOrderByNo;



    public void print(){
        DoubleLinkedListNode temp = head.getNext();   //用于辅助遍历
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public void add(DoubleLinkedListNode node){
        if(isOrderByNo){
            orderAdd(node);
        }else {
            unorderedAdd(node);
        }
    }

    /**
     * 有序添加
     * 当编号已存在时不能添加
     * @param node
     */
    private void orderAdd(DoubleLinkedListNode node){
        if(head.getNext() == null){
            head.setNext(node);
            return;
        }
        //定义一个变量指向头节点，用于辅助遍历
        DoubleLinkedListNode temp = head;
        //如果下一个节点不等于空 并且 下一个节点的No 小于等于 添加节点的No，就继续找
        while (temp.getNext() != null && temp.getNext().getNo() <= node.getNo()){
            if(node.getNo() == temp.getNext().getNo()){
                System.err.printf("编号%d已存在，添加失败！\n",node.getNo());
                return;
            }
            //后移
            temp = temp.getNext();
        }
        //判断是否将添加到最后一个节点
        if(temp.getNext() == null){
            tail.setPre(node);
            temp.setNext(node);
            node.setPre(temp);
            return;
        }
        //设置新节点的pre与next节点
        node.setNext(temp.getNext());
        node.setPre(temp);
        //将temp的next节点的pre设置为新添加的节点
        temp.getNext().setPre(node);
        //将temp的next设置为node
        temp.setNext(node);

    }

    /**
     * 无序添加
     * @param node
     */
    private void unorderedAdd(DoubleLinkedListNode node){
        if(head.getNext() == null){
            head.setNext(node);
            tail.setPre(node);
            return;
        }
        //定义一个变量指向头节点，用于辅助遍历
        DoubleLinkedListNode temp = head;
        //找到链表最后
        while (temp.getNext() != null){
            if(temp.getNext().getNo() == node.getNo()){
                System.err.printf("编号%d已存在，添加失败！\n",node.getNo());
                return;
            }
            //后移
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
        tail.setPre(node);
    }

    /**
     * 修改节点
     * 根据No查找节点并修改
     * @param newNode
     */
    public void update(DoubleLinkedListNode newNode){
        DoubleLinkedListNode temp = head.getNext();   //用于辅助遍历
        boolean isExists = false;   //标记是否找到
        //循环查找
        while (temp != null){
            if(temp.getNo() == newNode.getNo()){
                isExists = true;
                break;
            }
            temp = temp.getNext();
        }
        if(isExists){
            newNode.setNext(temp.getNext());
            newNode.setPre(temp.getPre());
            temp.getPre().setNext(newNode);
            //如果修改的不是最后一个节点
            if (temp.getNext() != null){
                temp.getNext().setPre(newNode);
            }else {
                tail.setPre(newNode);
            }
        }else {
            System.out.println("未找到需修改的节点");
        }
    }

    public void remove(int no){
        DoubleLinkedListNode temp = head.getNext();   //用于辅助遍历
        while (temp!= null){
            if(temp.getNo() == no){
                //temp的上一个节点的next设置为temp的next
                temp.getPre().setNext(temp.getNext());
                //如果不是最后一个节点
                if (temp.getNext() != null){
                    //temp的下一个节点的per设置为temp的per
                    temp.getNext().setPre(temp.getPre());
                }else { //如果是最后一个节点
                    tail.setPre(temp.getPre());
                }
                System.out.println("删除成功");
                return;
            }
            temp = temp.getNext();
        }
        System.out.printf("未找到编号为%d的节点,删除失败！\n",no);
    }













    public DoubleLinkedList() {
        head = new DoubleLinkedListNode(0,"");
        tail = new DoubleLinkedListNode(0,"");
    }

    public DoubleLinkedList(boolean isOrderByNo) {
        head = new DoubleLinkedListNode(0,"");
        tail = new DoubleLinkedListNode(0,"");
        this.isOrderByNo = isOrderByNo;
    }

    public void setOrderByNo(boolean orderByNo) {
        isOrderByNo = orderByNo;
    }
}
