package symmetryBinaryTree;

import java.util.*;

public class t101 {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
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
    public static boolean isSymmetric(TreeNode root) {
        // 对于每一层的所有节点构建一个列表？对列表做比较
        if (root == null) return false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (size > 0){
                TreeNode treeNode = queue.pollFirst();
                if (treeNode.left != null) levelList.add(treeNode.left.val);
                else levelList.add(null);
                if (treeNode.right != null) levelList.add(treeNode.right.val);
                else levelList.add(null);
                if (treeNode.left != null) queue.addLast(treeNode.left);
                if (treeNode.right != null) queue.addLast(treeNode.right);
                size--;
            }
            int listSize = levelList.size();
            for (int i = 0; i < levelList.size() / 2; i++){
                if (levelList.get(i) == null && levelList.get(listSize - i - 1) == null) continue;
                if (levelList.get(i) != null && levelList.get(listSize - i - 1) == null
                        || levelList.get(i) == null && levelList.get(listSize - i - 1) != null) return false;
                if (levelList.get(i).intValue() != levelList.get(listSize - i - 1).intValue()){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(3);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(3);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;
//        System.out.println(isSymmetric(treeNode1));

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.right = treeNode4;
        System.out.println(isSymmetric(treeNode1));
    }
}
