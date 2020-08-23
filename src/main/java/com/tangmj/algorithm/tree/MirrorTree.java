package com.tangmj.algorithm.tree;

/**
 * @author tangmingjian
 * 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *     4
 *   /   \
 *  2     7
 * / \   / \
 * 1  3 6  9
 * 镜像输出：
 * <p>
 *   4
 *  /  \
 *  7    2
 * / \  / \
 *9  6 3   1
 **/
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        //递归左右子树交换
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }
}
