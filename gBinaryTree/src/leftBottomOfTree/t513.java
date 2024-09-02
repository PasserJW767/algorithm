package leftBottomOfTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t513 {
    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     * 假设二叉树中至少有一个节点。
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
    public static int findBottomLeftValue(TreeNode root) {
        // 层序遍历解决此问题
        if (root == null) return 0;
        int result = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int record = size;
            while (size > 0){
                if (size == record) result = queue.peekFirst().val;
                TreeNode treeNode = queue.removeFirst();
                if (treeNode.left != null) queue.addLast(treeNode.left);
                if (treeNode.right != null) queue.addLast(treeNode.right);
                size--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        System.out.println(findBottomLeftValue(treeNode1)); // 1

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.left = treeNode7;
        System.out.println(findBottomLeftValue(treeNode1)); // 7
    }
}
