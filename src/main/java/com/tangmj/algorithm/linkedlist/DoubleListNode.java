package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 **/
public class DoubleListNode {
    int val;
    DoubleListNode last; //上一个
    DoubleListNode next; //下一个

    public DoubleListNode(int x) {
        val = x;
    }


    public static DoubleListNode of(String nodes) {
        if (nodes == null || nodes.length() == 0) {
            return null;
        }
        final String[] values = nodes.split(",");


        DoubleListNode head = new DoubleListNode(Integer.parseInt(values[0]));
        DoubleListNode pre = head;
        for (int i = 1; i < values.length; i++) {
            DoubleListNode curr = new DoubleListNode(Integer.parseInt(values[i]));
            pre.next = curr;
            curr.last = pre;
            pre = curr;

        }

        return head;
    }
}
