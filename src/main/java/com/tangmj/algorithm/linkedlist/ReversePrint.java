package com.tangmj.algorithm.linkedlist;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author tangmingjian
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 **/
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return null;
        }
        //借助栈的先进后出特性
        //先压栈
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        //后弹出栈
        final int total = stack.size();
        int[] result = new int[total];
        for (int i = 0; i < total; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public int[] reversePrint1(ListNode head) {
        //第一次遍历链表得到总节点数
        int total = 0;
        ListNode curr = head;
        while (curr != null) {
            total++;
            curr = curr.next;
        }
        if (total == 0) {
            return null;
        }
        int[] result = new int[total];
        //再次遍历链表倒序填充数组
        for (; total > 0; head = head.next) {
            result[--total] = head.val;
        }
        return result;
    }


    public static void main(String[] args) {
        final ListNode head = ListNode.of("1,3,2,5");
        ReversePrint reversePrint = new ReversePrint();
        final int[] reverse = reversePrint.reversePrint1(head);
        System.out.println(Arrays.toString(reverse));
    }
}
