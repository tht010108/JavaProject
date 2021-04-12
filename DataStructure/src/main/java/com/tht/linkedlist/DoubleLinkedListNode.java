package com.tht.linkedlist;

import lombok.Data;

/**
 * @ClassName : com.tht.linkedlist.DoubleLinkedListNode
 * @Description : 双向链表节点类
 * Author : space
 * CreatedDate 2021-04-12 09:27:39
 */
@Data
public class DoubleLinkedListNode implements Cloneable{
    private int no;
    private String name;
    private DoubleLinkedListNode next;  //指向下一个节点
    private DoubleLinkedListNode pre;  //指向上一个节点


    @Override
    protected DoubleLinkedListNode clone() {
        DoubleLinkedListNode node = null;
        try {
            node = (DoubleLinkedListNode) super.clone();
            node.next = null;
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return node;
    }

    @Override
    public String toString() {
        return "DoubleLinkedListNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public DoubleLinkedListNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
