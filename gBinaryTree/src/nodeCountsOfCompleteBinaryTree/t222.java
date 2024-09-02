package nodeCountsOfCompleteBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t222 {
    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     * 示例1：
     * 输入：root = [1,2,3,4,5,6]
     * 输出：6
     * 示例2：
     * 输入：root = []
     * 输出：0
     * 示例3：
     * 输入：root = [1]
     * 输出：1
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
    public static int countNodes(TreeNode root){
        // 利用完全二叉树的性质，如果是一个满二叉的话，可以通过公式计算节点数量
        // 从最下面的节点开始向上计算节点数量，则使用的遍历顺序是左右中/右左中，即后续遍历
        if (root == null) return 0; // 如果是空节点，则返回0证明此处高度为0
        // 求左子树深度和右子树深度
        int leftDepth = 0, rightDepth = 0;
        TreeNode left = root.left, right = root.right;
        while (left != null){
            leftDepth++;
            left = left.left;
        }
        while (right != null){
            rightDepth++;
            right = right.right;
        }
        if (leftDepth == rightDepth){
            return (2 << leftDepth) - 1;
        }
        int leftNodeNum = countNodes(root.left);
        int rightNodeNum = countNodes(root.right);
        return leftNodeNum + rightNodeNum + 1; // +1是加上根节点
    }
    public static int countNodes_mine(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int countOfNodes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                TreeNode treeNode = queue.pollFirst();
                countOfNodes++;
                if (treeNode.left != null) queue.addLast(treeNode.left);
                if (treeNode.right != null) queue.addLast(treeNode.right);
                size--;
            }
        }
        return countOfNodes;
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        System.out.println(countNodes(treeNode1));
    }
}
