package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 **/
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        //双指针找中间节点
        ListNode slow = head, fast = head;
        ListNode reverseSlow = null;
        while (fast != null && fast.next != null) {
            //快指针走两步
            fast = fast.next.next;

            ListNode next = slow.next;

            //将slow之前的节点翻转
            slow.next = reverseSlow;
            //后移指针
            reverseSlow = slow;
            slow = next;
        }

        //链表长度为奇数时slow再往后走一步
        if (fast != null)
            slow = slow.next;

        //开始比较reverseSlow和slow
        while (slow != null) {
            if (reverseSlow.val != slow.val)
                return false;
            reverseSlow = reverseSlow.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

        ListNode head = ListNode.of("1,2");
        boolean palindrome = isPalindrome.isPalindrome(head);
        System.out.println(palindrome);

        head = ListNode.of("1,2,2,1");
        palindrome = isPalindrome.isPalindrome(head);
        System.out.println(palindrome);

    }
}
