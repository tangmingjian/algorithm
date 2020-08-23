package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class ReverseList {

    //三指针
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, next;
        //pre    curr   next
        //null    ->1    ->2    ->3    ->4    ->5
        while (curr != null) {
            next = curr.next; //next:2
            //翻转指针
            curr.next = pre;  //null<-1   ...  2    ->3    ->4    ->5

            //指针后移
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //递归处理
    public ListNode reverseList1(ListNode head) {
        //结束条件:空或者只有一个节点
        if (head == null || head.next == null) return head;


        //等价条件:
        // 1.问题范围不断缩小
        // 2. reverseList1函数的作用是翻转链表,所以reverseList1(head.next)处理完毕后head.next已经完成翻转
        ListNode p = reverseList1(head.next);

        //head.next就是p的最后一个节点，最后一个节点的下一个指向head串起整个链表
        head.next.next = head;
        //最后一个节点的下一个指向空，避免环
        head.next = null;
        return p;
    }


    public DoubleListNode reverseList(DoubleListNode head) {
        if (head == null) {
            return head;
        }
        DoubleListNode pre = null, next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;

            pre = head;
            head = next;

        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of("1,2,3,4,5,6");
        ReverseList reverseList = new ReverseList();
        ListNode reverse = reverseList.reverseList1(head);
        System.out.println(reverse);


        DoubleListNode doubleListNode = DoubleListNode.of("1,2,3,4,5");

        DoubleListNode reversedDoubleListNode = reverseList.reverseList(doubleListNode);

        System.out.println(reversedDoubleListNode);
    }
}
