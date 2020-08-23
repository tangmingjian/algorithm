package com.tangmj.algorithm.tree;

/**
 * @author tangmingjian
 * 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 **/
public class RangeSumBST {
    public int rangeSumBST(TreeNode<Integer> root, int L, int R) {
        if (root == null) return 0;
        int rootVal = 0;
        if (rootVal >= L && rootVal <= R) rootVal = root.val;
        //递归左子树范围和
        int leftVal = rangeSumBST(root.left, L, R);
        //递归右子树范围和
        int rightVal = rangeSumBST(root.right, L, R);
        return rootVal + leftVal + rightVal;
    }
}
