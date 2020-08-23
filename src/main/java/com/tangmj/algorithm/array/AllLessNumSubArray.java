package com.tangmj.algorithm.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author tangmingjian
 * 给定一个整形数组arr，和一个整数num,
 * arr中的子数组sub,如果想达标，必须满足：sub中的最大值-sub中的最小值 <= num,
 * 返回arr中达标数组的数量
 **/
public class AllLessNumSubArray {

    //暴力解
    public int allLessNumSubArray0(int[] arr, int num) {
        int index = 0;
        for (int L = 0; L < arr.length; L++) {
            for (int R = L; R < arr.length; R++) {
                //两层循环得到所有可能的子数组 L...R

                int min = arr[L], max = arr[L];
                for (int i = L; i <= R; i++) {
                    //第三层循环，寻找子数组中最大和最小
                    int tmp = arr[i];
                    min = Math.min(min, tmp);
                    max = Math.max(max, tmp);
                }
                if (max - min <= num) {
                    index++;
                }
            }
        }
        //时间复杂度: O(n^3)
        return index;
    }

    public int allLessNumSubArray(int[] arr, int num) {
        if (arr == null || arr.length == 0) return 0;
        int res = 0;
        //[                     ]
        //  0 ,1 ,2 ,3 ,4 ,5 ,6

        // L.............R
        //     L1...R1
        //   max(arr[L,R])-min(arr[L,R]) <= num
        //=> max(arr[L1,R1])-min(arr[L1,R1]) <= num

        //以每一位置的元素为启始位置，向右扩展子数组，直到不能再扩位置(max(arr[L,R])-min(arr[L,R]) <= num 条件失效)
        //res+=R-L

        //大 -> 小
        LinkedList<Integer> qMax = new LinkedList<>();
        //小 -> 大
        LinkedList<Integer> qMin = new LinkedList<>();
        int L = 0;
        int R = 0;
        while (L < arr.length) {
            //窗口向右扩展
            while (R < arr.length) {
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                    qMax.pollLast();
                }
                qMax.addLast(R);

                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]) {
                    qMin.pollLast();
                }
                qMin.addLast(R);

                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > num) {
                    //扩展到不满足条件跳出
                    break;
                }

                R++;
            }
            //R此时是第一个不达标的位置
            //累加以当前L为启始位置的所有子数组个数
//            System.out.println(res);
            res += (R - L);

            //判断窗口左端是否过期
            if (qMax.peekFirst() == L) {
                qMax.pollFirst();
            }
            if (qMin.peekFirst() == L) {
                qMin.pollFirst();
            }

            //L右移
            L++;
        }

        return res;
    }


    public static void main(String[] args) {

        int[] arr = ArrayUtils.getRandomArray(5);
        int num = 3;
        System.out.println("参数:" + Arrays.toString(arr) + " ," + num);


        AllLessNumSubArray test = new AllLessNumSubArray();

        int sise0 = test.allLessNumSubArray0(arr, num);
        System.out.println(sise0);


        int size = test.allLessNumSubArray(arr, num);
        System.out.println(size);

    }
}
