package reverseBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t226 {
    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     * 示例 2：
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     *
     * 示例 3：
     * 输入：root = []
     * 输出：[]
     *
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
    public static TreeNode invertTree(TreeNode root) {
        // 感觉可以层序遍历，不断颠倒弹出节点的左右孩子
        if (root == null) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode cur = queue.pollFirst();
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                size--;
            }
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
