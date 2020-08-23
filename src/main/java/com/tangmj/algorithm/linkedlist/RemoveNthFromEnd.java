package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 **/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        //用双指针找到倒数n+1个节点
        while (fast != null && n-- >= 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //slow就是倒数n+1个节点

        //倒数n+1个节点的next指向倒数n节点的下一个节点(跳过倒数n节点)
        ListNode next = slow.next;
        slow.next = next.next;
        next.next = null;
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //todo 递归能不能解？？？
        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of("1,2,3,4,5");
        int n = 1;//[1,length]
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode node = removeNthFromEnd.removeNthFromEnd1(head, n);
        System.out.println(node);
    }
}
