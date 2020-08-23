package com.tangmj.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tangmingjian
 * 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 **/
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        Set<Integer> appeared = new HashSet<>();
        appeared.add(head.val);
        while (curr.next != null) {
            //后一个是否能加入set中
            if (appeared.add(curr.next.val)) {
                //能:指针后移
                curr = curr.next;
            } else {
                //不能:跳过
                curr.next = curr.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of("1,2,3,3,2,1");
        RemoveDuplicateNodes removeDuplicateNodes = new RemoveDuplicateNodes();
        ListNode node = removeDuplicateNodes.removeDuplicateNodes(head);
        System.out.println(node);
    }
}
