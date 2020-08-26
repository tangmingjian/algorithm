package com.tangmj.algorithm.sort;

import java.util.Arrays;

import static com.tangmj.algorithm.sort.SortUtils.swap;

/**
 * @author tangmingjian
 * 堆排序
 * 堆: 一个完全二叉树
 * 大根堆: 任何子树根节点比子节点大
 * 小根堆: 任何子树根节点比子节点小
 * 节点位置:
 * 根: (i-1)/2
 * 左: 2*i+1
 * 右: 2*i+2
 **/
public class HeapSort2 {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //默认就认为是大根堆,然后从最后往前调整
        for (int i = arr.length; i >= 0; --i) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private void heapInsert(int[] arr, int index) {
        //根节点小于当前位置，就交换
        while (index > 0 && arr[(index - 1) >> 1] < arr[index]) {
            swap(arr, (index - 1) >> 1, index);
            index = (index - 1) >> 1;//更新index位置(向上走)
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) | 1;
        while (left < heapSize) {//下方还有孩子节点
            //子节点中最大的一个
            int largest = (left + 1) < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //根节点和子节点中最大的
            largest = arr[index] >= arr[largest] ? index : largest;
            if (largest == index) break;

            swap(arr, index, largest);
            index = largest;
            left = (index << 1) | 1;
        }
    }

    public static void main(String[] args) {
        HeapSort2 test = new HeapSort2();
        int[] arr = {5, 3, 6, 1, 7, 4};
        System.out.println("原始数组:" + Arrays.toString(arr));
        test.sort(arr);
        System.out.println("排序后数组:" + Arrays.toString(arr));
    }
}

