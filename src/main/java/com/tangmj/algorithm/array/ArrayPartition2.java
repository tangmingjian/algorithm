package com.tangmj.algorithm.array;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 数组按某个值分区,左侧区+等于区+大于区
 **/
public class ArrayPartition2 {

    public void partition(int[] arr, int target) {
        int l = -1;//左边界
        int r = arr.length;//右边界
        int i = 0;//数组下标
        while (i < r) {
            if (arr[i] == target) {
                i++;//直接下一个，拉开相等区
            } else if (arr[i] < target) {
                //小于区的下一个和i交换，小于区右扩，i往下一个走
                ArrayUtils.swap(arr, ++l, i++);
            } else {
                //大于区的前一个和i交换，大于区左扩，i不动(因为从右侧来的数据还没比较过)
                ArrayUtils.swap(arr, --r, i);
            }
        }
    }

    public static void main(String[] args) {
        ArrayPartition2 test = new ArrayPartition2();
        int[] arr = {9, 5, 4, 3, 1, 1, 2, 7, 3, 9};
        int target = 3;
        test.partition(arr, target);
        System.out.println(Arrays.toString(arr));
    }
}
