package com.tangmj.algorithm.array;

/**
 * @author tangmingjian 2020-08-20 10:23 PM
 **/
public class BSSearch {

    public int index(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0, M = 0, R = sortedArr.length - 1;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (sortedArr[M] == target) {
                return M;
            } else if (sortedArr[M] > target) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return -1;
    }


    //大于等于target最左的位置
    //{1, 4, 7, 8, 9} 8 => 3(7)
    //       M

    public int nearLeftIndex(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0, M = 0, R = sortedArr.length - 1;
        int index = -1;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (sortedArr[M] >= target) {
                R = M - 1;
                index = M;
            } else {
                L = M + 1;
            }
        }
        return index;
    }


    public int nearRightIndex(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0, M = 0, R = sortedArr.length - 1;
        int index = -1;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (sortedArr[M] <= target) {
                index = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        BSSearch test = new BSSearch();
        int[] sortedArr = {1, 4, 7, 8, 9};
        int target = 7;
        int index = test.index(sortedArr, target);
        System.out.println(index);


        int firstGtOne = test.nearLeftIndex(sortedArr, 8);
        System.out.println(firstGtOne);

        int firstLtOne = test.nearRightIndex(sortedArr, 5);
        System.out.println(firstLtOne);
    }
}
