package com.tht.test;

import com.tht.stack.ArrayStack;
import com.tht.stack.Calculator;

import java.util.Scanner;

/**
 * @ClassName : com.tht.test.StackTest
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-13 09:14:19
 */

public class StackTest {
    public static void main(String[] args) {
        calculatorTest();
    }

    public static void arrayStack(){
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.print();
        System.out.println(stack.pop());
        stack.print();
    }

    public static void calculatorTest(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Calculator calcu = new Calculator();
        System.out.println(calcu.calculate(str));
    }
}

