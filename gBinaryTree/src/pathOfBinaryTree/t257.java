package pathOfBinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class t257 {
    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     *
     * 叶子节点 是指没有子节点的节点。
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
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<String> vec = new ArrayList<>();
        traversal(root, vec, result);
        return result;
    }
    public static void traversal(TreeNode root, List<String> vec, List<String> result){
        // 将当前节点的值加到vec里
        vec.addLast(String.valueOf(root.val));
        // 叶子节点，可以记录当前路径~
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < vec.size(); i++) {
                sb.append(vec.get(i));
                if (i < vec.size() - 1) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
            return;
        }
        // 回溯过后，继续找左右结点
        if (root.left != null){
            // 遍历左结点
            traversal(root.left, vec, result);
            // 弹出加入过的内容
            vec.removeLast();
        }
        if (root.right != null){
            // 遍历右结点
            traversal(root.right, vec, result);
            vec.removeLast();
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        System.out.println(binaryTreePaths(treeNode1));
    }
}
