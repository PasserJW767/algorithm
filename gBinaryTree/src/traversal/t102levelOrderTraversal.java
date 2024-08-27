package traversal;

import com.sun.source.tree.Tree;

import java.util.*;

public class t102levelOrderTraversal {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        TreeNode cur = root;
        // 使用队列，记录每一层的个数
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(cur);
        while (!queue.isEmpty()){
            // 通过size来逐层添加
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            while (size > 0){
                cur = queue.pollFirst();
                levelResult.add(cur.val);
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
                size--;
            }
            result.add(levelResult);
        }
        return result;
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
        System.out.println(levelOrder(treeNode1));
    }
}
