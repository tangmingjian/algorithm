package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 链表相交
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 **/
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //a: 1->2->3
        //           ->4->5->6
        //b:   -1->2
        ListNode currA = headA, currB = headB;
        while (currA != currB) {
            //a走完开始走b
            currA = currA == null ? headB : currA.next;
            //b走完开始走a
            currB = currB == null ? headA : currB.next;

            //如果有环会在环处相遇，没有环currA和currB都将是null
        }
        return currA;
    }

    public static void main(String[] args) {

    }
}
