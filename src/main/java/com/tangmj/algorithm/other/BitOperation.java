package com.tangmj.algorithm.other;

/**
 * @author tangmingjian 2020-08-20 11:10 PM
 **/
public class BitOperation {

    public void test1(){
        int a = 10;
        int b = a<<1 |1;
        System.out.println(b);
    }

    public void test2(){
        int a = 10;
        int b = 10;
        int c = a^b;
        int d = a ^ 0;
        System.out.println(c);
        System.out.println(d);
    }

    public static void main(String[] args) {
        BitOperation test = new BitOperation();
        test.test1();
        test.test2();
    }
}
