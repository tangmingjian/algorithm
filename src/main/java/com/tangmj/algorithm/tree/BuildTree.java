package com.tangmj.algorithm.tree;

/**
 * @author tangmingjian 2020-07-28
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15  7
 **/
public class BuildTree {

    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了15.14%的用户
     * 内存消耗：91 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归结束条件
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        //根节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        //左子树节点个数
        int leftCount = 0;
        do {
            leftCount++;
        } while (inorder.length > leftCount && rootVal != inorder[leftCount]);
        //说明没有左子树
        if (leftCount==preorder.length) {
            leftCount = 0;
        }

        //左子树数前序数组
        int[] leftSubPreorder = new int[leftCount];
        System.arraycopy(preorder, 1, leftSubPreorder, 0, leftCount);
        //左子树数中序数组
        int[] leftSubInorder = new int[leftCount];
        System.arraycopy(inorder, 0, leftSubInorder, 0, leftCount);

        //构建左子树
        root.left = buildTree(leftSubPreorder, leftSubInorder);

        int rightCount = preorder.length - leftCount - 1;
        //右子树数前序数组
        int[] rightSubPreorder = new int[rightCount];
        System.arraycopy(preorder, leftCount + 1, rightSubPreorder, 0, rightCount);
        //右子树数中序数组
        int[] rightSubInorder = new int[rightCount];
        System.arraycopy(inorder, leftCount + 1, rightSubInorder, 0, rightCount);
        //构建右子树
        root.right = buildTree(rightSubPreorder, rightSubInorder);
        return root;
    }

    public static void main(String[] args) {
        BuildTree test = new BuildTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = test.buildTree(preorder, inorder);

        System.out.println(treeNode);
    }
}
