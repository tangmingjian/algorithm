package com.tangmj.algorithm.array;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 数组按某个值分区,左右两侧不要求有序
 **/
public class ArrayPartition {

    public void partition(int[] arr, int target) {
        int index = -1;//左边界
        int i = 0;//数组下标
        while (index < arr.length && i < arr.length) {
            if (arr[i] > target) {
                i++;//直接后移，拉出大于target区域
            } else {
                ArrayUtils.swap(arr, index + 1, i++);//i位置和小于区的下一个交换
                index++;//小于区域后扩
            }
        }
    }

    public static void main(String[] args) {
        ArrayPartition test = new ArrayPartition();
        int[] arr = {5, 4, 1, 1, 2, 7, 3, 9};
        int target = 3;
        test.partition(arr, target);
        System.out.println(Arrays.toString(arr));
    }
}
