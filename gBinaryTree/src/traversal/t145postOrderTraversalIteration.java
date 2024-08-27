package traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class t145postOrderTraversalIteration {
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
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // 后续遍历：左右中
        // 由前序遍历推后续遍历：中左右 ---(调换后面两项顺序)---> 中右左 ---(反转数组)---> 左右中
        Stack<TreeNode> stack = new Stack<>();

        // 前序遍历：中左右
        TreeNode cur = null;
        stack.push(root);
        while (!stack.isEmpty()){
            cur = stack.pop();
            result.add(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return result.reversed();
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(postOrderTraversal(treeNode1));
        TreeNode treeNode4 = new TreeNode(1);
        System.out.println(postOrderTraversal(treeNode4));
    }
}
