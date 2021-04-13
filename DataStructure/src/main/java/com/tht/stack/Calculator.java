package com.tht.stack;

import java.util.Stack;

/**
 * @ClassName : com.tht.stack.Calculator
 * @Description : 计算器
 * Author : space
 * CreatedDate 2021-04-13 10:02:55
 */
public class Calculator {


    public int calculate(String str){
        //定义两个栈，用来存放数值与符号
        Stack<Integer> numStack = new Stack();
        Stack<Character> operStack = new Stack();
        //定义相关变量
        int index = 0;  //用于扫描
        char ch = ' ';  //用于存储扫描到的符号
        int num1 = 0;
        int num2 = 0;
        char oper = ' ';
        int res = 0;
        //循环扫描str,得到str每一个字符
        while (str.length() != index){
            ch = str.charAt(index);
            if (isOper(ch)){    //如果是符号
                if(operStack.isEmpty()){    //如果栈为空
                    //直接入栈
                    operStack.push(ch);
                }else {
                    //如果ch的优先级大于operStach栈顶符号的优先级
                    if (operProiority(ch) > operProiority(operStack.peek())){
                        //直接入栈
                        operStack.push(ch);
                    }else {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        if(oper == '-' || oper == '/'){
                            res = (int)calculate(num2,num1,oper);
                        }else {
                            res = (int)calculate(num1,num2,oper);
                        }
                        //将结果入数栈
                        numStack.push(res);
                        //将扫描的ch入符号栈
                        operStack.push(ch);
                    }
                }
            }else {
                //如果当前扫描的ch是不第一个并且前一个字符是数值
                if (index != 0 && !isOper(str.charAt(index-1))){
                    //取出上一个数值*10 加上当前的数值
                    numStack.push(numStack.pop()*10+(int) ch - 48);
                }else {
                    //ASCLL码中'0'的值为8
                    numStack.push((int) ch - 48);
                }
            }
            index++;
        }
        //当str扫描完毕后，从两个栈中取出相应的数和符号进行运算
        while (!operStack.isEmpty()){    //符号栈为空则计算结束
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            if(oper == '-' || oper == '/'){
                res = (int)calculate(num2,num1,oper);
            }else {
                res = (int)calculate(num1,num2,oper);
            }
            //将结果入数栈
            numStack.push(res);
        }
        return numStack.pop();
    }




    /**
     * 计算
     * @param num1 数值1
     * @param num2 数值2
     * @param oper 符号
     * @return 计算结果
     */
    public double calculate(double num1,double num2,int oper){
        double res = 0;
        switch (oper){
            case '+':
                res = add(num1,num2);
                break;
            case '-':
                res = minus(num1,num2);
                break;
            case '*':
                res = multiplication(num1,num2);
                break;
            case '/':
                res = division(num1,num2);
                break;
            case '%':
                res = remainder((int)num1,(int)num2);
            break;
            default:
                throw new RuntimeException("运算符错误");
        }
        return res;
    }
    /**
     * 加法
     * @param num1 数值1
     * @param num2 数值2
     * @return 结果
     */
    public double add(double num1,double num2){
        return num1+num2;
    }
    /**
     * 减法
     * @param num1 数值1
     * @param num2 数值2
     * @return 结果
     */
    public double minus(double num1,double num2){
        return num1-num2;
    }
    /**
     * 乘法
     * @param num1 数值1
     * @param num2 数值2
     * @return 结果
     */
    public double multiplication(double num1,double num2){
        return num1*num2;
    }
    /**
     * 除法
     * @param num1 数值1
     * @param num2 数值2
     * @return 结果
     */
    public double division(double num1,double num2){
        return num1/num2;
    }
    /**
     * 取模
     * @param num1 数值1
     * @param num2 数值2
     * @return 余数
     */
    public int remainder(int num1,int num2){
        return num1%num2;
    }
    /**
     * 判断是否为符号
     * @param oper 字符
     * @return
     */
    public boolean isOper(char oper){
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }
    /**
     * 返回符号优先级，如果返回0代表传入的参数有误
     * @param oper 符号
     * @return 优先级，优先级越高数字越大
     */
    public int operProiority(int oper){
        if (oper == '+' || oper == '-'){
            return 1;
        }else if (oper == '*' || oper == '/'){
            return 2;
        }
        return 0;
    }
}
