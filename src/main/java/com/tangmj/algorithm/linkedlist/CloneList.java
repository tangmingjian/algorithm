package com.tangmj.algorithm.linkedlist;

import java.util.HashMap;

/**
 * @author tangmingjian
 * 克隆链表
 **/
public class CloneList {


    public ListNode clone(ListNode head) {
        if (head == null) return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr, new ListNode(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).rand = map.get(curr.rand);
            curr = curr.next;
        }
        return map.get(head);
    }

    //不使用额外空间
    public ListNode clone1(ListNode head) {
        if (head == null) return null;

        //o1->o2->o3->null
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            //clone出来的新节点,挂在当前节点后面
            ListNode node = new ListNode(curr.val);
            curr.next = node;
            node.next = next;
            curr = next;
        }
        //o1->n1->o2->n2->o3->n3->null
        //开始处理rand节点
        curr = head;
        while (curr != null) {
            //向后跳两步
            ListNode next = curr.next.next;
            //设置新节点的rand
            curr.next.rand = curr.rand == null ? null : curr.rand.next;
            curr = next;
        }
        //开始分离
        curr = head;
        ListNode res = curr.next;
//        ListNode copyCurr = res;
//        while (curr != null) {
//            ListNode next = curr.next.next;
//            curr.next = next;
//
//            copyCurr.next = next != null ? next.next : null;
//            curr = next;
//            copyCurr = copyCurr.next;
//        }
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = next == null ? null : next.next;
            curr = next;
        }

        return res;
    }

    public ListNode clone2(ListNode head) {
        if (head == null) return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr, new ListNode(curr.val));
            curr = curr.next;
        }

        curr = head;
        ListNode res = map.get(head);
        ListNode resCurr = res;
        while (curr != null) {
            resCurr = map.get(curr);
            ListNode next = curr.next;
            ListNode resNext = resCurr.next;

            resCurr.next = resNext;

            curr = next;
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        private ListNode rand;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    ", hashCode=" + this.hashCode() +
                    ", val=" + val +
                    ", next=" + next +
                    ", rand=" + (rand == null ? null : rand.hashCode() + ":" + String.valueOf(rand.val)) +
                    '}';
        }

        public ListNode of(String nodes) {
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


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(3);
        ListNode t3 = new ListNode(4);
        head.next = t1;
        t1.next = t2;
        t2.next = t3;

        t1.rand = t2;
        t2.rand = t3;
        t3.rand = t1;
        CloneList test = new CloneList();
        System.out.println(head);
        ListNode clone = test.clone1(head);
        System.out.println(clone);

    }
}
