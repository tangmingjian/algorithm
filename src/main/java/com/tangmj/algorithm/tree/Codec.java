package com.tangmj.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tangmingjian 2020-07-28
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 *      1
 *     / \
 *   2   3
 *      / \
 *     4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 **/
public class Codec {
    private String SEP = ",";
    private String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            if (parent == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(parent.val).append(SEP);
            q.offer(parent.left);
            q.offer(parent.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        data = data.substring(1, data.length() - 1);

        String[] nodes = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            String next = nodes[index++];
            if (!NULL.equals(next)) {
                parent.left = new TreeNode(Integer.valueOf(next));
                q.offer(parent.left);
            }
            next = nodes[index++];
            if (!NULL.equals(next)) {
                parent.right = new TreeNode(Integer.valueOf(next));
                q.offer(parent.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec test = new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = null;
        left.right = new TreeNode(4);
        left.right.left = null;
        left.right.right = null;
        TreeNode right = new TreeNode(3);
        right.left = null;
        right.right = null;
        root.left = left;
        root.right = right;

        String serialize = test.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = test.deserialize(serialize);
        System.out.println(deserialize);
    }
}
