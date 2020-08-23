package com.tangmj.algorithm.tree;

/**
 * @author tangmingjian 2020-07-26
 * 二叉树的遍历
 **/
public class Traverse<T> {
    private String NULL = "#";
    private String SEP = ",";

    public String preTraverse(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        pre(root, sb);
        return sb.toString();
    }

    private void pre(TreeNode<T> root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        pre(root.left, sb);
        pre(root.right, sb);
    }

    public String inTraverse(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        in(root, sb);
        return sb.toString();
    }

    private void in(TreeNode<T> root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        in(root.left, sb);
        sb.append(root.val).append(SEP);
        in(root.right, sb);
    }

    public String postTraverse(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        post(root, sb);
        return sb.toString();
    }

    private void post(TreeNode<T> root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        pre(root.left, sb);
        pre(root.right, sb);
        sb.append(root.val).append(SEP);
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
        TreeNode<Integer> root = TreeNode.of(treeNodes,"#", TreeNode.TraverseType.PRE);

        Traverse<Integer> test = new Traverse<>();
        String result = test.preTraverse(root);
        System.out.println("前序序列化结果:"+result);
        System.out.println(treeNodes.equals(result));
    }
}
