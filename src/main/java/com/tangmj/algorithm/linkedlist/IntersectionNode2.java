package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 链表相交节点,a、b链表可能有环，也可能无环
 **/
public class IntersectionNode2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cycleNodeA = CycleNode.cycleNode(headA);
        ListNode cycleNodeB = CycleNode.cycleNode(headB);
        if (cycleNodeA == null && cycleNodeB == null) {
            return intersectionNodeWithNoLoop(headA, headB);
        } else if (cycleNodeA != null && cycleNodeB != null) {
            return intersectionNodeWithBothLoop(headA, cycleNodeA, headB, cycleNodeB);
        } else {
            //一个有环一个无环，不可能相交
            return null;
        }
    }

    private ListNode intersectionNodeWithBothLoop(ListNode headA, ListNode cycleNodeA, ListNode headB, ListNode cycleNodeB) {
        if (cycleNodeA == cycleNodeB) {
            ListNode a = headA;
            ListNode b = headB;
            int n = 0;
            while (a != cycleNodeA) {
                a = a.next;
                n++;
            }
            while (b != cycleNodeB) {
                b = b.next;
                n--;
            }

            a = n >= 0 ? headA : headB;
            b = a == headA ? headB : headA;

            n = Math.abs(n);

            while (n-- > 0) {
                a = a.next;
            }
            while (a != b) {
                a = a.next;
                b = b.next;
            }
            //此时找到a、b相交的节点，可能在环外，也可能在环上
            return a;

        } else {
            //环节点不是同一个，有两种可能
            ////1. 两个链表各自成环
            ////2. 环节点在同一个环的不同节点上
            ListNode tmp = cycleNodeA.next;
            //走一圈，如果遇不到cycleNodeB说明没有相遇
            while (tmp != cycleNodeA) {
                if (tmp == cycleNodeB) {
                    return cycleNodeA;
                }
                tmp = tmp.next;
            }
            return null;
        }
    }


    private ListNode intersectionNodeWithNoLoop(ListNode headA, ListNode headB) {
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
        tmp = c;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = c;

        IntersectionNode2 test = new IntersectionNode2();

        ListNode intersectionNode2 = test.getIntersectionNode(a, b);
        System.out.println(intersectionNode2);

    }
}

