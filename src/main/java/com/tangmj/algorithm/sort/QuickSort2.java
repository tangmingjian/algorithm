package com.tangmj.algorithm.sort;

import java.util.Arrays;

import static com.tangmj.algorithm.sort.SortUtils.swap;

/**
 * @author tangmingjian
 * 快排
 **/
public class QuickSort2 {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);

    }

    private void sort(int[] arr, int L, int R) {
        if (L >= R) return;
        int[] equalArea = partition(arr, L, R);
        //递归左
        sort(arr, L, equalArea[0] - 1);
        //递归右
        sort(arr, equalArea[1] + 1, R);
    }

    private int[] partition(int[] arr, int L, int R) {
        if (L == R) return new int[]{L, R};
        else if (L > R) return new int[]{-1, -1};
        //按arr[R] 做分区, [<,=,>]
        int less = L - 1;
        int index = L;
        int more = R;
        while (index < more) {
            //小于区推着等于区往大于区走
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);//大于区第一个和R位置交换
        return new int[]{less + 1, more};//返回等于区的左右边界
    }

    public static void main(String[] args) {
        QuickSort2 test = new QuickSort2();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));

    }
}
