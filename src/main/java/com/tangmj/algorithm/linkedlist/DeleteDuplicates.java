package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 **/
public class DeleteDuplicates {

    //保留第一个重复节点
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            //比较当前址和下一个值
            if (curr.val == next.val) {
                //相等:下一个略过
                curr.next = next.next;
                next.next = null;
            } else {
                //不相等:指针正常后移
                curr = curr.next;
            }
        }
        return head;
    }

    //保留最后一个重复节点
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        while (curr != null && curr.next != null) {
            boolean hasDuplicates = false;
            //一直找到最有一个相等的节点
            while (curr != null && curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                hasDuplicates = true;
            }
            if (hasDuplicates) {
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of("1,1,2");
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode deleted = deleteDuplicates.deleteDuplicates1(head);
        System.out.println(deleted);


        head = ListNode.of("1,1,2,3,3");
        deleted = deleteDuplicates.deleteDuplicates1(head);
        System.out.println(deleted);

        head = ListNode.of("1,2,3,4,5");
        deleted = deleteDuplicates.deleteDuplicates1(head);
        System.out.println(deleted);
    }
}
