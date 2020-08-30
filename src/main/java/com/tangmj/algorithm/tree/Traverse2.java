package com.tangmj.algorithm.tree;

import java.util.Stack;

/**
 * @author tangmingjian
 * 二叉树的遍历(非递归)
 **/
public class Traverse2<T> {

    public void pre(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();

    }


    private void in(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            //把左边先压完
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                //左压不动时，弹出打印，开始处理右(方式一样:一只压右的左,知道压不动)
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }

        }
        System.out.println();

    }

    public void post(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().val + " ");
        }

        System.out.println();
    }


    public static void main(String[] args) {
        /**
         *      1
         *     / \
         *    2   3
         *  / \   / \
         * # #   4  #
         *      / \
         *     #  #
         */
        String treeNodes = "1,2,#,#,3,4,#,#,#,";
        TreeNode<Integer> root = TreeNode.of(treeNodes, "#", TreeNode.TraverseType.PRE);

        Traverse2<Integer> test = new Traverse2<>();
        test.pre(root);
        test.in(root);
        test.post(root);

    }
}
