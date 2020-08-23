package com.tangmj.algorithm.other;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 异或操作
 **/
public class EORTest {

    //n & ((~n) + 1) 得到低位1

    //  4       -> 00000100
    // ~4       -> 00001011
    // ~4+1     -> 00001100
    // 4&(~4+1) -> 00000100


    //  5       -> 00000101
    // ~5       -> 11111010
    // ~5+1     -> 11111011
    // 5&(~5+1) -> 00000001
    //
    public int bit1Count(int n) {
        int count = 0;
        while (n != 0) {
            int rightOne = n & ((~n) + 1);//得到最低为1
            count++;
            n ^= rightOne; //去掉地位1
        }
        return count;
    }


    public int bit1Count1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {//最低位是1
                count++;
            }
            n >>= 1;//右移1位
        }
        return count;
    }

    //有一个奇数的
    public int oddTimesNum(int[] arr) {
//        int eor = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            eor ^= arr[i];
//        }
//        return eor;

        // n^0 = n
        // n^n = 0
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }

    //有两个奇数的
    public int[] oddTimesNum2(int[] arr) {
        int[] res = new int[2];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // 假设奇数个数分别是a,b
        // eor = a^b 且 eor!=0
        // eor & ((~eor) + 1) -> 得到最低位的1

        int rightOne = eor & ((~eor) + 1);

        int eor1 = 0;
        //用rightOne分组，可以将a、b分到不同组
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) == 1) {
                eor1 ^= arr[i];//同组内异或组后得到a或者b
            }
        }
        res[0] = eor1;
        res[1] = eor1 ^ eor;//到b或者a
        return res;
    }

    public static void main(String[] args) {
        EORTest test = new EORTest();

        int a = 7;
        int bit1Count = test.bit1Count1(a);
        System.out.println(bit1Count);

        int[] arr = {1, 5, 2, 5, 1};
        int i = test.oddTimesNum(arr);
        System.out.println(i);

        int[] arr1 = {1, 5, 2, 5, 1,3,7,7,};
        int[] ints = test.oddTimesNum2(arr1);
        System.out.println(Arrays.toString(ints));
    }

}
