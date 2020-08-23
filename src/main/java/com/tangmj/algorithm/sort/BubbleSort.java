package com.tangmj.algorithm.sort;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 冒泡排序: 每一轮操作最大的数会浮动到范围内最后
 **/
public class BubbleSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //[5,3,6,1,7,4]

        //在一个范围
        //// 0 - N-1
        //// 0 - N-2
        //// 0 - N-3
        //// ...
        //// 0 - 0

        //做什么事
        //// 看(寻址)
        //// 比较
        //// 交换

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {//控制范围在:0 — i
                if (arr[j] > arr[j + 1]) {//两两看+比较+交换
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort test = new BubbleSort();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));

    }
}
