package levelTraversal;

import java.util.ArrayDeque;
import java.util.Deque;

public class t104 {
    /**
     * 给定一个二叉树 root ，返回其最大深度。
     *
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：3
     *
     * 输入：root = [1,null,2]
     * 输出：2
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
    public static int maxDepth(TreeNode root) {
        // 层序遍历计算树的最大高度
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur = root;
        if (root == null) return 0;
        int maxDepth = 0;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                cur = queue.pollFirst();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                size--;
            }
            maxDepth++;
        }
        return maxDepth;
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
        System.out.println(maxDepth(treeNode1));
    }
}
