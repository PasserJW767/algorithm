package pathOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class t112 {
    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     * 叶子节点 是指没有子节点的节点。
     * */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root, targetSum - root.val);
    }

    public static boolean traversal(TreeNode root, int targetSum) {
        if (root.val == targetSum) return true;
        // 求有没有合适的路径满足路径上的和==targetSum
        // 前序
        if (root.left == null && root.right == null && targetSum == 0) return true;
        if (root.left == null && root.right == null && targetSum != 0) return false;
        // 左
        if (root.left != null){
            targetSum -= root.left.val;
            if (traversal(root.left, targetSum)) return true;
            targetSum += root.left.val;
        }
        // 右
        if (root.right != null){
            targetSum -= root.right.val;
            if (traversal(root.right, targetSum)) return true;
            targetSum += root.right.val;
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(13);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode1.right = treeNode6;
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        treeNode8.right = treeNode9;
        System.out.println(hasPathSum(treeNode1, 22));
    }
}
