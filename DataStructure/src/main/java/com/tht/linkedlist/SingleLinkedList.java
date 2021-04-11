package com.tht.linkedlist;

import java.util.Stack;

/**
 * @ClassName : com.tht.linkedlist.SingleLinkedList
 * @Description : 单链表
 * Author : space
 * CreatedDate 2021-04-11 14:13:43
 */
public class SingleLinkedList {
    /**
     * 头节点，不存放具体数据
     */
    private SingleLinkedListNode head;
    /**
     * 是否排序
     */
    private boolean isOrderByNo;



    public void add(SingleLinkedListNode node){
        if (isOrderByNo){
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
    private void orderAdd(SingleLinkedListNode node){
        //定义一个变量指向头节点，用于辅助遍历
        SingleLinkedListNode temp = head;
        //如果下一个节点不等于空 并且 下一个节点的No 小于等于 添加节点的No，就继续找
        while (temp.getNext() != null && temp.getNext().getNo() <= node.getNo()){
            if(node.getNo() == temp.getNext().getNo()){
                System.err.printf("编号%d已存在，添加失败！\n",node.getNo());
                return;
            }
            //后移
            temp = temp.getNext();
        }
        //将需添加节点node的next设置为temp的next
        node.setNext(temp.getNext());
        //将temp的next设置为node
        temp.setNext(node);
    }

    /**
     * 无序添加
     * @param node
     */
    private void unorderedAdd(SingleLinkedListNode node){
        //定义一个变量指向头节点，用于辅助遍历
        SingleLinkedListNode temp = head;
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
    }

    /**
     * 修改节点
     * 根据No查找节点并修改
     * @param newNode
     */
    public void update(SingleLinkedListNode newNode){
        SingleLinkedListNode temp = head;   //用于辅助遍历
        boolean isExists = false;   //标记是否找到
        //循环查找
        while (temp.getNext() != null){
            if(temp.getNext().getNo() == newNode.getNo()){
                isExists = true;
                break;
            }
            temp = temp.getNext();
        }
        if(isExists){
            newNode.setNext(temp.getNext().getNext());
            temp.setNext(newNode);
        }else {
            System.out.println("未找到需修改的节点");
        }
    }

    public void remove(int no){
        SingleLinkedListNode temp = head;   //用于辅助遍历
        while (temp.getNext() != null){
            if(temp.getNext().getNo() == no){
                //temp的next指向下下个节点
                temp.setNext(temp.getNext().getNext());
                System.out.println("删除成功");
                return;
            }
            temp = temp.getNext();
        }
        System.out.printf("未找到编号为%d的节点,删除失败！\n",no);
    }

    /**
     * 根据编号获取节点
     * @param no 编号
     * @return
     */
    public SingleLinkedListNode get(int no){
        SingleLinkedListNode temp = head.getNext();   //用于辅助遍历
        while (temp != null){
            if(temp.getNo() == no){
                return temp;
            }
            temp = temp.getNext();
        }
        System.out.printf("未找到编号为%d的节点",no);
        return null;
    }


    /**
     * 获取链表长度
     * @return
     */
    public int getLength(){
        SingleLinkedListNode temp = head.getNext();   //用于辅助遍历
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }


    /**
     * 链表反转
     */
    public void reverse(){
        //如果节点数量小于等于1，直接返回
        if(head.getNext() == null || head.getNext().getNext() == null){
            return;
        }
        //定义reverseHead用于保存反转后的链表
        SingleLinkedListNode reverseHead = new SingleLinkedListNode(0,"");
        SingleLinkedListNode temp = head.getNext();   //用于辅助遍历
        SingleLinkedListNode next = null;   //指向temp的下一个节点
        //循环遍历，每次将当前节点保存到reverseHead的最前端
        while (temp != null){
            //将下一个节点保存
            next = temp.getNext();
            //将temp的下一个节点指向新链表的前端
            temp.setNext(reverseHead.getNext());
            //将新链表的头节点指向temp
            reverseHead.setNext(temp);
            //继续遍历原链表
            temp = next;
        }
        head.setNext(reverseHead.getNext());
    }

    public static SingleLinkedList merge(SingleLinkedList list1,SingleLinkedList list2){
        SingleLinkedList newLinkedList = new SingleLinkedList();    //用于存放新链表
        SingleLinkedListNode temp1 = list1 == null ? null : list1.getHead().getNext();   //用于辅助遍历node1
        SingleLinkedListNode temp2 = list2 == null ? null : list2.getHead().getNext();   //用于辅助遍历node2

        //遍历两个链表
        while (temp1 != null || temp2 != null){
            if(temp1 == null){
                //为了不影响原链表，所以使用了拷贝
                newLinkedList.add(temp2.clone());
                temp2 = temp2.getNext();
            }else if(temp2 == null){
                newLinkedList.add(temp1.clone());
                temp1 = temp1.getNext();
            }else if (temp1.getNo() <= temp2.getNo()){
                newLinkedList.add(temp1.clone());
                temp1 = temp1.getNext();
            }else {
                newLinkedList.add(temp2.clone());
                temp2 = temp2.getNext();
            }
        }
        return newLinkedList;
    }

    /**
     * 打印链表
     */
    public void print(){
        //判断链表是否为空
        if (head.getNext() == null){
            System.out.println("链表为空");
        }
        //定义一个变量指向头节点，用于辅助遍历
        SingleLinkedListNode temp = head.getNext();
        while (temp != null){
            //打印
            System.out.println(temp);
            //后移
            temp = temp.getNext();
        }
    }


    /**
     * 逆序打印链表
     */
    public void reversePrint(){
        //判断链表是否为空
        if (head.getNext() == null){
            System.out.println("链表为空");
        }
        //用于辅助遍历
        SingleLinkedListNode temp = head.getNext();
        //创建栈，用于保存遍历的节点
        Stack<SingleLinkedListNode> stack = new Stack<>();
        //将所以节点添加到栈中
        while (temp != null){
            //将temp添加到栈中
            stack.add(temp);
            //后移
            temp = temp.getNext();
        }
        //循环栈并打印
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }













    //构造方法和get/set方法
    public SingleLinkedList() {
        head = new SingleLinkedListNode(0,"",null);
        isOrderByNo = false;
    }

    public SingleLinkedList(boolean isOrderByNo) {
        head = new SingleLinkedListNode(0,"",null);
        this.isOrderByNo = isOrderByNo;
    }

    public SingleLinkedList(SingleLinkedListNode head, boolean isOrderByNo) {
        this.head = head;
        this.isOrderByNo = isOrderByNo;
    }

    public boolean isOrderByNo() {
        return isOrderByNo;
    }

    public void setOrderByNo(boolean orderByNo) {
        isOrderByNo = orderByNo;
    }

    public SingleLinkedListNode getHead() {
        return head;
    }

}
