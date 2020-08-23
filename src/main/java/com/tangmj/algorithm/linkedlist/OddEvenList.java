package com.tangmj.algorithm.linkedlist;

/**
 * @author tangmingjian
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * <p>
 **/
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenHead = even;
        // odd    even
        // 1     ->2     ->3     ->4     ->5     ->NULL

        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;    //1->3->4->5->NULL
            odd = odd.next;
            even.next = even.next.next;  //2->4->5->NULL
            even = even.next;
        }
        //将偶数节点加在奇数节点后边
        odd.next = evenHead;
        return oddHead;
    }

    public ListNode oddEvenList1(ListNode head) {
        ListNode odd = new ListNode(-1), even = new ListNode(-1);
        ListNode currOdd = odd, currEven = even;
        //依次取出两个节点，第一个放在奇数节点后，第二个放在偶数节点后
        while (head != null) {
            currOdd.next = head;
            head = head.next;
            currOdd = currOdd.next;
            if (head != null) {
                currEven.next = head;
                head = head.next;
                currEven = currEven.next;
            } else {
                //最后一个节点是奇数，需要将最后偶数节点的next指针指向空，否则出现环
                currEven.next = null;
            }

        }
        currOdd.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of("1,2,3,4,5");

        OddEvenList oddEvenList = new OddEvenList();
        ListNode node = oddEvenList.oddEvenList1(head);
        System.out.println(node);

    }
}
