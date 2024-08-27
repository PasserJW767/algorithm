package traversal;

import java.util.ArrayList;
import java.util.List;

public class t145postOrderTraversalRecursion {
    /**
     * 对二叉树的节点进行后序遍历，使用的是递归的方式
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
    public static void traversal(t144preOrderTraversalRecursion.TreeNode cur, List<Integer> result){
        if (cur == null) return;
//        后序遍历：左右中
        traversal(cur.left, result);
        traversal(cur.right, result);
        result.add(cur.val);
    }
    public static List<Integer> postOrderTraversal(t144preOrderTraversalRecursion.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        traversal(root, result);
        return result;
    }
    public static void main(String[] args) {
        t144preOrderTraversalRecursion.TreeNode treeNode1 = new t144preOrderTraversalRecursion.TreeNode(1);
        t144preOrderTraversalRecursion.TreeNode treeNode2 = new t144preOrderTraversalRecursion.TreeNode(2);
        t144preOrderTraversalRecursion.TreeNode treeNode3 = new t144preOrderTraversalRecursion.TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(postOrderTraversal(treeNode1));
        t144preOrderTraversalRecursion.TreeNode treeNode4 = new t144preOrderTraversalRecursion.TreeNode(1);
        System.out.println(postOrderTraversal(treeNode4));
    }
}
