package balanceBinaryTree;

import nodeCountsOfCompleteBinaryTree.t222;

public class t110 {
    /**
     * 给定一个二叉树，判断它是否是平衡二叉树，平衡二叉树定义为：⼀个二叉树每个节点 的左右两个⼦树的⾼度差的绝对值不超过1。
     * 示例1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     * 示例2：
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     * 示例3：
     * 输入：root = []
     * 输出：true
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

    /***
     * 二叉树中的高度是什么？深度是什么？
     * 二叉树的高度指的是当前节点与底部节点离的距离
     * 二叉树的深度指的是当前节点与根节点的距离
     * 求高度的时候，我们使用的是后序遍历（将底部的结果不断向上汇总求解）
     * 求深度的时候，我们使用的是前序遍历（向下求解）
     *
     * 在这里需要求的是高度，因为我们要判断左右子树是否平衡，就要分别求出左右子树的高度
     * @param root
     * @return
     */
    public static int getHeight(TreeNode root){
        if (root == null) return 0; // 如果到达了底部节点，则向上返回0
        int leftHeight = getHeight(root.left); // 求解左子树的高度
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right); // 求解右子树的高度
        if (rightHeight == -1) return -1;
        // 中间节点处理左右子树的结果
        if (Math.abs(leftHeight - rightHeight) > 1){
            // 如果一棵二叉树中有一个子树不是平衡二叉树，则整个二叉树都不是平衡二叉树
            return -1;
        } else return 1 + Math.max(leftHeight, rightHeight);
    }
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    public static int count_Mine(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return count_Mine(root.right) + 1;
        if (root.right == null) return count_Mine(root.left) + 1;
        return Math.max(count_Mine(root.left), count_Mine(root.right)) + 1;
    }
    public static boolean isBalanced_Mine(TreeNode root) { // 后序遍历，需要体现出左右中
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isBalanced_Mine(root.left) && isBalanced_Mine(root.right) && Math.abs(count_Mine(root.left) - count_Mine(root.right)) <= 1;
//        // 左
//        int left = count(root.left);
//        // 右
//        int right = count(root.right);
//        // 中间
//        return Math.abs(left - right) <= 1;
//
//        return isBalanced(root.left) && isBalanced(root.right);
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
//        System.out.println(isBalanced(treeNode1));

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode7;
        System.out.println(isBalanced(treeNode1));

//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.right = treeNode2;
//        treeNode2.right = treeNode3;
//        System.out.println(isBalanced(treeNode1));

    }
}
