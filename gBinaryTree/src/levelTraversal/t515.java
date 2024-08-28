package levelTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class t515 {
    /**
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     * 示例1：
     * 输入: root = [1,3,2,5,3,null,9]
     * 输出: [1,3,9]
     * 示例2：
     * 输入: root = [1,2,3]
     * 输出: [1,3]
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
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        deque.addLast(cur);
        while (!deque.isEmpty()){
            int size = deque.size();
            int largestValues = Integer.MIN_VALUE;
            while (size > 0){
                cur = deque.pollFirst();
                largestValues = cur.val > largestValues ? cur.val : largestValues;
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
                size--;
            }
            result.add(largestValues);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        System.out.println(largestValues(treeNode1));
    }
}
