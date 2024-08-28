package levelTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class t637 {
    /**
     * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10^-5 以内的答案可以被接受。
     *
     * 示例1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[3.00000,14.50000,11.00000]
     * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
     * 因此返回 [3, 14.5, 11] 。
     *
     * 示例2：
     * 输入：root = [3,9,20,15,7]
     * 输出：[3.00000,14.50000,11.00000]
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
    public static List<Double> averageOfLevels(TreeNode root) {
        // 层序遍历求解每一层的节点值，对每一层的结点值算平均值
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        deque.addLast(cur);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelResult = new ArrayList<>();
            while (size > 0){
                cur = deque.pollFirst();
                levelResult.add(cur.val);
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
                size--;
            }
            result.add(levelResult);
        }
        List<Double> returnResult = new ArrayList<>();
        for (List<Integer> integers : result) {
            double sum = 0.0;
            double count = 0.0;
            for (Integer integer : integers) {
                sum += integer;
                count += 1.0;
            }
            returnResult.add(sum / count);
        }
        return returnResult;
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
        System.out.println(averageOfLevels(treeNode1));
    }
}
