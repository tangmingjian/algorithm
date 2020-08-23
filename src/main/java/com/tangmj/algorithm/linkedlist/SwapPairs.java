package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 **/
public class SwapPairs {


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        //pre   curr  next
        //-1    ->1    ->2    ->3    ->4
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            pre.next = curr.next;  // -1->2
            curr.next = next.next; //  1->3
            next.next = curr;      //  2->1
            //pre    next   curr
            //-1    ->2    ->1    ->3    ->4

            //1 2已经调整好，继续调整后面节点
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;

    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode next = head.next;
        //交换前两个节点位置
        head.next = next.next;
        next.next = head;

        //递归处理head的后续节点
        head.next = swapPairs1(head.next);
        return next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of("1,2,3,4,5");
        SwapPairs swapPairs = new SwapPairs();
        final ListNode listNode = swapPairs.swapPairs1(head);
        System.out.println(listNode);
    }
}
