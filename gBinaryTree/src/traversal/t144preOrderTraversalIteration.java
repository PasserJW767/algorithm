package traversal;

import java.util.*;

public class t144preOrderTraversalIteration {
    /**
     * 对二叉树的节点进行前序遍历，使用的是递归的方式
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
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // 使用队列来实现遍历 -> 好像是不可以的
//        Deque<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 前序遍历：中左右
        TreeNode cur = null;
        stack.push(root);
        while (!stack.isEmpty()){
            cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(preorderTraversal(treeNode1));
        TreeNode treeNode4 = new TreeNode(1);
        System.out.println(preorderTraversal(treeNode4));
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(2);
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        System.out.println(preorderTraversal(treeNode5));
    }
}
