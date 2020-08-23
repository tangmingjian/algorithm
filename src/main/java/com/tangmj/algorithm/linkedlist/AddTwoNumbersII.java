package com.tangmj.algorithm.linkedlist;

import java.util.Stack;

/**
 * @author tangmingjian 2020-07-03 上午10:07
 * 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 **/
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //借助栈
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        for (; l1 != null; l1 = l1.next) s1.push(l1);

        for (; l2 != null; l2 = l2.next) s2.push(l2);

        ListNode pre = null, curr = null;
        int carry = 0;
        while (s1.size() > 0 || s2.size() > 0) {
            int v1 = s1.size() > 0 ? s1.pop().val : 0;
            int v2 = s2.size() > 0 ? s2.pop().val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            //反方向构建链表

            //新节点
            curr = new ListNode(sum % 10);
            //新节点指向前一个节点
            curr.next = pre;

            //指针后移
            pre = curr;

        }
        if (carry > 0) {
            curr = new ListNode(carry);
            curr.next = pre;
        }

        return curr;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.of("5,7,2");
        ListNode l2 = ListNode.of("5,6,4");
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        ListNode listNode = addTwoNumbersII.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

}
