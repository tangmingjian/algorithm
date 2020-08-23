package com.tangmj.algorithm.sort;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 插入排序: 将新的一个数插入到已排序范围内合适的位置
 **/
public class InsertionSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //[5,3,6,1,7,4]

        //在一个范围,想让这个范围都有序
        //// 0 - 1
        //// 0 - 2
        //// 0 - 3
        //// ...
        //// 0 - N

        //做什么事
        //// 看(寻址)
        //// 比较
        //// 两两交换

        //时间复杂度:
        ////不稳定：和输入参数有关
        ////// 最好：[1,2,3] O(N)
        ////// 最坏：[3,2,1] O(N^2) 每个数都要做(i-1)次看+比较+交换
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                SortUtils.swap(arr, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort test = new InsertionSort();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));

    }
}
