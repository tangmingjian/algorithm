package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 **/
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = head;
        int n = k;
        while (h != null && n-- > 0)
            h = h.next;
        //不够K个，直接返回
        if (n > 0) return head;

        n = k;
        //开始翻转K个节点
        ListNode pre = null, curr = head, next = null;
        while (curr != null && n-- > 0) {
            next = curr.next;
            //翻转指针
            curr.next = pre;

            //指针后移
            pre = curr;
            curr = next;
        }
        //翻转结束后，头指针是pre,尾节点是head,后续需要处理的第一个节点是curr

        //递归处理后续节点
        head.next = reverseKGroup(curr, k);
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of("1,2,3,4,5");
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode reversed = reverseKGroup.reverseKGroup(head, 2);
        System.out.println(reversed);
    }
}
