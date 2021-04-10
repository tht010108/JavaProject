package com.tht.sparsearr;

import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * @ClassName : com.tht.sparsearr.SparseArray
 * @Description : 稀疏数组
 * Author : space
 * CreatedDate 2021-04-10 17:59:05
 */
public class SparseArray {
    /**
     * 二维数组转稀疏数组
     * @param arr
     * @return
     */
    public static int[][] toSparseArray(int[][] arr){
        int count = getValidValueCount(arr, 0);
        //创建稀疏数组
        int[][] sparseArr = new int[count+1][3];
        //为第一行赋值
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = count;
        //为其余行赋值
        int index = 0; //用于记录sparseArr最新有效数据的下标
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if(arr[i][j] != 0){
                    index++;
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }

    /**
     * 获取有效数据个数
     * @param arr 二维数组
     * @param invalidValue 指定无效数据
     * @return 有效数据个数
     */
    public static int getValidValueCount(int[][] arr,int invalidValue){
        int count = 0;
        for (int[] row : arr) {
            for (int val: row){
                if(val != invalidValue)
                    count++;
            }
        }
        return count;
    }

    /**
     * 稀疏数组转二维数组
     * @param sparseArray 稀疏数组
     * @return 二维数组
     */
    public static int[][] toArray2(int[][] sparseArray){
        //创建二维数组
        int[][] arr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        //读取sparseArray数据并赋值给 arr2
        for (int i = 1; i < sparseArray.length; i++){
            arr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return arr2;
    }

}
