package com.tangmj.algorithm.sort;

/**
 * @author tangmingjian 2020-08-20 9:22 AM
 **/
public class SortUtils {

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
