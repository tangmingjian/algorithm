package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 **/
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" +( next == null ? "null" : String.valueOf(next.val)) +
                '}';
    }

    public static ListNode of(String nodes) {
        if (nodes == null || nodes.length() == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        final String[] values = nodes.split(",");
        for (String value : values) {
            curr.next = new ListNode(Integer.parseInt(value));
            curr = curr.next;
        }
        return dummy.next;
    }
}
