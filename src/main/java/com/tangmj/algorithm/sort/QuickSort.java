package com.tangmj.algorithm.sort;

import java.util.Arrays;

import static com.tangmj.algorithm.sort.SortUtils.swap;

/**
 * @author tangmingjian
 * 快排
 **/
public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);

    }

    private void sort(int[] arr, int L, int R) {
        if (L >= R) return;
        int partition = partition(arr, L, R);
        sort(arr, L, partition - 1);
        sort(arr, partition + 1, R);
    }

    private int partition(int[] arr, int L, int R) {
        if (L == R) return L;
        else if (L > R) return -1;
        //按arr[R] 做分区 [<=,>]
        int less = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] > arr[R]) {
                index++;
            } else {
                swap(arr, ++less, index++);
            }
        }
        swap(arr, ++less, R);
        return less;
    }

    public static void main(String[] args) {
        QuickSort test = new QuickSort();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));

    }
}
