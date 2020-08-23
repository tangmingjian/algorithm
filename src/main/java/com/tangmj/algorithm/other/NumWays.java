package com.tangmj.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangmingjian 2020-08-08 1:37 PM
 * 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 **/
public class NumWays {

    public int numWays(int n) {
        //结束条件
        if (n <= 1) return 1;
        //等价关系
        // 每一跳:
        //      1步，剩下的有f(n-1)种跳法
        //      2步，剩下的有f(n-2)种跳法
        return numWays(n - 1) + numWays(n - 2);
        //有重复计算问题
    }

    Map<Integer, Integer> calculated = new HashMap<>();

    public int numWays1(int n) {
        //结束条件
        if (n <= 1) return 1;


        Integer result = calculated.get(n);
        if (result != null) {
            return result;
        }
        //等价关系
        // 每一跳:
        //      1步，剩下的有f(n-1)种跳法
        //      2步，剩下的有f(n-2)种跳法
        result = numWays1(n - 1) + numWays1(n - 2);
        calculated.put(n, result);
        return result;
    }

    public int numWays2(int n){
        return 0;
    }
}
