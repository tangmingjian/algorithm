package com.tangmj.algorithm.sort;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 归并排序
 **/
public class MergeSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int L, int R) {
        if(L==R){
            return;
        }
        int M = L + ((R - L) >> 1);
        sort(arr, L, M);         //左端有序
        sort(arr, M + 1, R);  //右端有序
        merge(arr, L, M, R);    //合并左右两端
    }

    private void merge(int[] arr, int L, int M, int R) {
        int[] helper = new int[R - L + 1];
        int index = 0;
        int lIndex = L;
        int rIndex = M + 1;
        while (lIndex <= M && rIndex <= R) {
            helper[index++] = arr[lIndex] <= arr[rIndex] ? arr[lIndex++] : arr[rIndex++];
        }
        while (lIndex <= M){
            helper[index++] = arr[lIndex++];
        }
        while (rIndex <= R){
            helper[index++] = arr[rIndex++];
        }
        for (int i = 0; i < helper.length ; i++) {
            arr[L+i] = helper[i];
        }
    }

    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));
    }
}
