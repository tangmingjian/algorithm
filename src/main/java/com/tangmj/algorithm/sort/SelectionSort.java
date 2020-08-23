package com.tangmj.algorithm.sort;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 选择排序:在范围内选出最小(大)的数和当前第一个数交换
 * 时间复杂度(多少常数操作，忽略低阶和常数)：N^2
 **/
public class SelectionSort {
    //[5,3,6,1,7,4]

    //在一个范围
    //// 0 - N
    //// 1 - N
    //// 2 - N
    //// ...
    //// N-1 - N

    //做什么事
    //// 看(寻址)
    //// 比较
    //// 交换

    //时间复杂度: (N*(1+1)+1) + ((N-1)*(1+1)+1)+ ((N-2)*(1+1)+1) + ... + 1*(1+1)+1) ~= N^2
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {//控制操作范围
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {//在范围i-N内看+比较,选出最小
                min = arr[min] < arr[j] ? min : j;
            }
            SortUtils.swap(arr, i, min);//交换
        }
    }

    public static void main(String[] args) {
        SelectionSort test = new SelectionSort();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));

    }
}
