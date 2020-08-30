package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 链表相交节点
 **/
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        //a、b走相同的长度，如果相交就在同一个点上相遇，
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //找到a链表的最后一个节点
        ListNode a = headA;
        ListNode endA = a;
        int n = 0;
        while (endA.next != null) {
            endA = endA.next;
            n++;
        }
        //找到b链表的最后一个节点
        ListNode b = headB;
        ListNode endB = b;
        while (endB.next != null) {
            endB = endB.next;
            n--;
        }
        //如果a、b链表的最后一个节点不是一个节点，说明没有相交
        if (endA != endB) {
            return null;
        }

        //有相交，从较长链表头出发走差值步
        a = n >= 0 ? headA : headB;
        b = a == headA ? headB : headA;
        n = Math.abs(n);
        while (n-- > 0) {
            a = a.next;
        }

        //a、b开始同时走，相遇节点就是入环的第一个节点
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode b = ListNode.of("1,2,3,4,5,6");
        ListNode a = ListNode.of("6,5,4,3");
        ListNode c = ListNode.of("9,8,7");
        ListNode tmp = a;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = c;
        tmp = b;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = c;

        IntersectionNode test = new IntersectionNode();
        ListNode intersectionNode = test.getIntersectionNode(a, b);
        System.out.println(intersectionNode);

        ListNode intersectionNode2 = test.getIntersectionNode2(a, b);
        System.out.println(intersectionNode2);

    }
}

