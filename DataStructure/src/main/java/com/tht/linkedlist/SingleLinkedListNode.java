package com.tht.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName : com.tht.linkedlist.SingleLinkedListNode
 * @Description : 单链表节点类
 * Author : space
 * CreatedDate 2021-04-11 14:17:41
 */
@Data
@AllArgsConstructor
public class SingleLinkedListNode implements Cloneable {
    private int no;
    private String name;
    private SingleLinkedListNode next;  //指向下一个节点


    public SingleLinkedListNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingleLinkedListNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public SingleLinkedListNode clone() {
        SingleLinkedListNode node = null;
        try {
            node = (SingleLinkedListNode) super.clone();
            node.next = null;
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return node;
    }
}
