package com.tangmj.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tangmingjian 2020-07-28
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 **/
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root==null) {
            return new int[]{};
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode<Integer> parent = q.poll();
            if (parent==null) {
                continue;
            }
            values.add(parent.val);
            q.offer(parent.left);
            q.offer(parent.right);
        }

        int[] result = new int[values.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = values.get(i);
        }
        return result;
    }
}
