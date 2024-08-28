package levelTraversal;

import java.util.ArrayDeque;
import java.util.Deque;

public class t111 {
    /**
     *
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     *
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     *
     * 示例 2：
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
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
    public static int minDepth(TreeNode root) {
        // 当左右孩子都为空时候说明找到了最小高度
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur = root;
        queue.addLast(cur);
        int minDepth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                cur = queue.pollFirst();
                if (cur.left == null && cur.right == null) return minDepth;
                else {
                    if (cur.left != null) queue.addLast(cur.left);
                    if (cur.right != null) queue.addLast(cur.right);
                }
                size--;
            }
            minDepth++;
        }
        return minDepth;
    }
    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(9);
//        TreeNode treeNode3 = new TreeNode(20);
//        TreeNode treeNode4 = new TreeNode(15);
//        TreeNode treeNode5 = new TreeNode(7);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;
//        System.out.println(minDepth(treeNode1));


        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;
        System.out.println(minDepth(treeNode1));
    }
}
