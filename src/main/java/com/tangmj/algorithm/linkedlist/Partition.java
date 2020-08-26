package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 给链表分区:小于在左,等于在中间,大于在右
 **/
public class Partition {

    public ListNode partition(ListNode head, int pivot) {
        if (head == null) {
            return head;
        }
        ListNode lh = null, lt = null;//小于头尾
        ListNode eh = null, et = null;//等于头尾
        ListNode gh = null, gt = null;//大于头尾

        //开始分区
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = null;
            int val = curr.val;
            if (val < pivot) {
                if (lt == null) {
                    lh = lt = curr;
                } else {
                    lt.next = curr;
                    lt = lt.next;
                }
            } else if (val == pivot) {
                if (et == null) {
                    eh = et = curr;
                } else {
                    et.next = curr;
                    et = et.next;
                }
            } else {
                if (gt == null) {
                    gh = gt = curr;
                } else {
                    gt.next = curr;
                    gt = gt.next;
                }
            }
            curr = next;
        }

//        System.out.println(lh);
//        System.out.println(eh);
//        System.out.println(gh);

        //开始将三个区串联起来
        if (lh == null) {
            lh = eh;
            lt = et;
        } else {
            lt.next = eh;
            lt = et == null ? lt : et;
        }

        if (lh == null) {
            lh = gh;
        } else {
            lt.next = gh;
        }
        return lh;
    }


    public static void main(String[] args) {
        Partition test = new Partition();
        ListNode head = ListNode.of("2,6,3,8,1,9,3,10");
        int pivot = 3;
        System.out.println("-----------三个区都有-------------");
        System.out.println(head);
        ListNode partition = test.partition(head, pivot);
        System.out.println(partition);

        System.out.println("-----------没有小于-------------");
        head = ListNode.of("3,6,8,3,9,10");
        System.out.println(head);
        partition = test.partition(head, pivot);
        System.out.println(partition);

        System.out.println("-----------没有等于-------------");
        head = ListNode.of("2,6,8,1,9,10");
        System.out.println(head);
        partition = test.partition(head, pivot);
        System.out.println(partition);

        System.out.println("-----------没有大于-------------");
        head = ListNode.of("2,3,1,3");
        System.out.println(head);
        partition = test.partition(head, pivot);
        System.out.println(partition);

        System.out.println("-----------只有小于-------------");
        head = ListNode.of("2,1");
        System.out.println(head);
        partition = test.partition(head, pivot);
        System.out.println(partition);

        System.out.println("-----------只有等于-------------");
        head = ListNode.of("3,3,3,3,");
        System.out.println(head);
        partition = test.partition(head, pivot);
        System.out.println(partition);


        System.out.println("-----------只有大于-------------");
        head = ListNode.of("5,7,4,5,9");
        System.out.println(head);
        partition = test.partition(head, pivot);
        System.out.println(partition);
    }
}
