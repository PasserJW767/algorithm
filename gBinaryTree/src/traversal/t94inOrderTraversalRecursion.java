package traversal;

import java.util.ArrayList;
import java.util.List;

public class t94inOrderTraversalRecursion {
    /**
     * 对二叉树的节点进行中序遍历，使用的是递归的方式
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
    public static void traversal(TreeNode cur, List<Integer> result){
        if (cur == null) return;
//        中序遍历：左中右
        traversal(cur.left, result);
        result.add(cur.val);
        traversal(cur.right, result);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        traversal(root, result);
        return result;
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(inorderTraversal(treeNode1));
        TreeNode treeNode4 = new TreeNode(1);
        System.out.println(inorderTraversal(treeNode4));
    }
}
