package com.tangmj.algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tangmingjian
 **/
public class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;

    TreeNode(T x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public enum TraverseType {
        PRE {
            @Override
            <T> TreeNode<T> deserialize(Deque<String> nodes, String NULL) {
                String rootValue = nodes.removeFirst();
                if (NULL.equals(rootValue)) {
                    return null;
                 }
                TreeNode root = new TreeNode(rootValue);
                root.left = deserialize(nodes, NULL);
                root.right = deserialize(nodes, NULL);
                return root;
            }
        },
        /**
         * 中序遍历无法还原成树
         */
        IN {
            @Override
            <T> TreeNode<T> deserialize(Deque<String> nodes, String NULL) {
                return null;
            }
        },
        POST {
            @Override
            <T> TreeNode<T> deserialize(Deque<String> nodes, String NULL) {
                String rootValue = nodes.removeLast();
                if (NULL.equals(rootValue)) {
                    return null;
                }
                TreeNode root = new TreeNode(rootValue);
                root.right = deserialize(nodes, NULL);
                root.left = deserialize(nodes, NULL);
                return root;
            }
        },
        LEVEL {
            @Override
            <T> TreeNode<T> deserialize(Deque<String> nodes, String NULL) {
                String rootValue = nodes.removeFirst();
                if (NULL.equals(rootValue)) {
                    return null;
                }
                TreeNode root = new TreeNode(rootValue);
                Deque<TreeNode> q = new LinkedList<>();
                q.offer(root);
                while (!q.isEmpty()) {
                    TreeNode parent = q.poll();
                    String leftValue = nodes.removeFirst();
                    if (!NULL.equals(leftValue)) {
                        parent.left = new TreeNode(leftValue);
                        q.offer(parent.left);
                    }
                    String rightValue = nodes.removeFirst();
                    if (!NULL.equals(rightValue)) {
                        parent.right = new TreeNode(rightValue);
                        q.offer(parent.right);
                    }

                }
                return root;
            }
        };

        abstract <T> TreeNode<T> deserialize(Deque<String> nodes, String NULL);

    }

    /**
     * 用字符串构建树(必须包含'null'节点)
     *
     * @param treeNodes    字符串
     * @param NULL         'null'表达形势
     * @param traverseType 遍历方式
     * @param <T>          范型
     * @return 树
     */
    public static <T> TreeNode<T> of(String treeNodes, String NULL, TraverseType traverseType) {
        if (treeNodes == null || treeNodes.length() == 0) return null;
        if (NULL == null) return null;
        if (traverseType == null) return null;

        String[] nodeValues = treeNodes.split(",");
        Deque<String> deque = new LinkedList();
        for (String value : nodeValues) {
            deque.addLast(value);
        }

        return traverseType.deserialize(deque, NULL);

    }


    public static void main(String[] args) {
        /**
         *      1
         *     / \
         *    2   3
         *  / \   / \
         * #  #   4  #
         *       / \
         *      #  #
         */
        String levelNodes = "1,2,3,#,#,4,#,#,#";
        TreeNode<String> level = of(levelNodes, "#", TraverseType.LEVEL);
        System.out.println(level);


        String postNodes = "#,#,2,#,#,4,#,3,1";
        TreeNode<String> post = of(postNodes, "#", TraverseType.POST);
        System.out.println(post);


        String preNodes = "1,2,#,#,3,4,#,#,#";
        TreeNode<String> pre = of(preNodes, "#", TraverseType.PRE);
        System.out.println(pre);
    }
}
