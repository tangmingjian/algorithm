package com.tangmj.algorithm.sort;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 归并排序
 **/
public class MergeSort2 {

    public void sort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        int k = 1;//每次处理的左部分规模
        int length = arr.length;
        while (k < length) {
            int L = 0;
            while (L < length) {
                //每2K一组排序
                //计算每一轮L,M,R的位置，然后归并
                int M = L + k - 1;
                if (M >= length) {
                    break;
                }
                int R = Math.min(M + k, length - 1);
                merge(arr, L, M, R);
                L = R + 1;//下一组的开始位置
            }
            //规模扩大一倍
            k <<= 1;
        }
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
        MergeSort2 test = new MergeSort2();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));
    }
}

