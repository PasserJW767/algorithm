import java.util.ArrayList;
import java.util.List;

public class Main {
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

        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            if (hasPathSum(root.left, targetSum)) return true;
        }
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)) return true;
        }
        return false;
    }

    public static int pathSum(TreeNode root, int targetSum){
        // 往下遍历后回溯
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) return 0;
            else return -1;
        }

        if (root.left != null){
            targetSum = pathSum(root.left, targetSum);
            if (targetSum == 0) return 0;
            targetSum -= root.left.val;
        }
        if (root.right != null){
            targetSum = pathSum(root.right, targetSum);
            if (targetSum == 0) return 0;
            targetSum -= root.right.val;
        }
        return targetSum;

    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
//        System.out.println(hasPathSum(treeNode1));
    }
}
