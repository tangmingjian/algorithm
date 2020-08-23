package com.tangmj.algorithm.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author tangmingjian 2020-08-17 9:12 PM
 * 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 **/
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
//        if (nums.length < k) return nums;
        //结果集长度 -> nums.length - k + 1
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        //双端队列
        //保证从左到右的顺序是: 大->小
        LinkedList<Integer> qMax = new LinkedList<>();
        //滑动窗口R一直向右走
        for (int R = 0; R < nums.length; R++) {
            //入队
            while (!qMax.isEmpty() && nums[R] >= nums[qMax.getLast()]) {
                ////遇到比尾巴小的，将尾巴弹出
                qMax.pollLast();
            }
            ////小于尾巴的入队
            qMax.addLast(R);


            //出队
            ////过期下标:-> R-k
            if (qMax.peekFirst() == R - k) {
                qMax.pollFirst();
            }

            //以上维护好了窗口

            //窗口形成以后开始收集结果
            if (R >= k - 1) {
                ////长度为k的滑动窗口形成后，往结果集里设置元素
                res[index++] = nums[qMax.peekFirst()];
            }

        }
        return res;
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        //if (nums.length < k) return nums;
        //结果集长度 -> nums.length - k + 1
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //维护最大值
            if (i == i - k) max = nums[i];

            else max = Math.max(max, nums[i]);

            //窗口形成
            if (i >= k - 1) {
                res[index++] = max;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        MaxSlidingWindow test = new MaxSlidingWindow();
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;

        int[] nums = {1, -1};
        int k = 1;

//        int[] nums = {9, 11};
//        int k = 2;
        int[] res = test.maxSlidingWindow1(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
