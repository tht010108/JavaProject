package com.tht.test;

import com.tht.sparsearr.SparseArray;

import java.util.Arrays;

/**
 * @ClassName : com.tht.test.SparseArrayTest
 * @Description : 稀疏数组测试类
 * Author : space
 * CreatedDate 2021-04-10 18:00:06
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        //0表示没有棋子，1表示白子，2表示黑子
        int chessArr[][] = new int[11][11];
        chessArr[2][2] = 1;
        chessArr[3][5] = 2;
        chessArr[2][3] = 1;
        printArr(chessArr);
        int[][] sparseArray = SparseArray.toSparseArray(chessArr);
        printArr(sparseArray);
        int[][] array2 = SparseArray.toArray2(sparseArray);
        printArr(array2);
    }

    public static void printArr(int[][] arr){
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
