package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 **/
public class GetKthFromEnd {


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //计算总节点数
        int total = 0;
        ListNode curr = head;
        while (curr != null) {
            total++;
            curr = curr.next;
        }
        if (total < k) {
            return null;
        }
        //走total-k步
        for (int i = 0; i < total - k; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        //fast先走k步
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }

        //fast和slow一起走，fast走到尽头时slow就是解
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        final ListNode head = ListNode.of("1,2,3,4,5");
        int k = 5;

        final GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        final ListNode kth = getKthFromEnd.getKthFromEnd1(head, k);
        System.out.println(kth);
    }
}
