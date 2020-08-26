package com.tangmj.algorithm.linkedlist;

import java.util.Stack;

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
        //todo 将翻转的数据恢复
        return true;
    }


    //使用辅助空间栈1
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (!stack.isEmpty()) {
            if (node.val != stack.pop().val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }


    //使用辅助空间栈2
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = slow.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        boolean res = true;
        node = head;
        while (!stack.isEmpty()) {
            if (node.val != stack.pop().val) {
                res = false;
                break;
            }
            node = node.next;
        }
        return res;
    }

    //不使用额外空间
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //把slow的后续节点翻转,slow.next=null
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;

        ListNode pre = null, next = null;
        while (right != null) {
            next = right.next;
            right.next = pre;

            pre = right;
            right = next;
        }
        right = pre;

        ListNode helpR = right;//用来恢复数据
        //开始对比
        boolean res = true;
        while (left != null) {
            if (left.val != right.val) {
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        //恢复被翻转的数据
        pre = null;
        next = null;
        while (helpR != null) {
            next = helpR.next;
            helpR.next = pre;

            pre = helpR;
            helpR = next;
        }
        slow.next = pre;
        return res;
    }


    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

        ListNode head = ListNode.of("1,2");
//        System.out.println("方法0:" + isPalindrome.isPalindrome(head));
        System.out.println("方法1:" + isPalindrome.isPalindrome1(head));
        System.out.println("方法2:" + isPalindrome.isPalindrome2(head));
        System.out.println("方法3:" + isPalindrome.isPalindrome3(head));


        head = ListNode.of("1,2,2,1");
        System.out.println("------------------------------");
//        System.out.println("方法0:" + isPalindrome.isPalindrome(head));
        System.out.println("方法1:" + isPalindrome.isPalindrome1(head));
        System.out.println("方法2:" + isPalindrome.isPalindrome2(head));
        System.out.println("方法3:" + isPalindrome.isPalindrome3(head));

        System.out.println(head);
    }
}
