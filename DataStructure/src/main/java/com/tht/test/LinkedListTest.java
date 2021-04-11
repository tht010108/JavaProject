package com.tht.test;

import com.tht.linkedlist.SingleLinkedList;
import com.tht.linkedlist.SingleLinkedListNode;

/**
 * @ClassName : com.tht.test.LinkedListTest
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-11 14:29:16
 */
public class LinkedListTest {
    public static void main(String[] args) {
        singleLinkedListTest();
    }

    public static void singleLinkedListTest(){
        SingleLinkedList singleLinkedList = new SingleLinkedList(true);
        singleLinkedList.add(new SingleLinkedListNode(1,"wd"));
        singleLinkedList.add(new SingleLinkedListNode(5,"zl"));
        singleLinkedList.add(new SingleLinkedListNode(2,"gy"));
        singleLinkedList.add(new SingleLinkedListNode(0,"y"));
        singleLinkedList.add(new SingleLinkedListNode(9,"x"));
        /*singleLinkedList.print();
        singleLinkedList.update(new SingleLinkedListNode(1,"x"));
        System.out.println("修改后：");
        singleLinkedList.print();
        singleLinkedList.remove(1);
        System.out.println("删除后：");
        singleLinkedList.print();
        System.out.println("node: "+singleLinkedList.get(3));*/
        //singleLinkedList.reverse();
        //singleLinkedList.print();
        //System.out.println("逆序打印");
        //singleLinkedList.reversePrint();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList(true);
        //singleLinkedList2.add(new SingleLinkedListNode(6,"wd"));
        //singleLinkedList2.add(new SingleLinkedListNode(3,"zl"));
        SingleLinkedList list = SingleLinkedList.merge(singleLinkedList, null);
        list.get(0).setName("www");
        list.print();
        System.out.println("原1：");
        singleLinkedList.print();
        System.out.println("原2：");
        singleLinkedList2.print();
    }

    public static void singleLinkedListNodeTest(){
        SingleLinkedListNode node = new SingleLinkedListNode(1,"tht");
        node.setNext(new SingleLinkedListNode(3,"zl"));
        SingleLinkedListNode clone = node.clone();
    }
}
