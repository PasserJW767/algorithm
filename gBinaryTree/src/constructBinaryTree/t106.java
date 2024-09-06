package constructBinaryTree;

import pathOfBinaryTree.t112;

import java.util.Arrays;

public class t106 {
    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     *
     * 示例 1：
     * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 输出：[3,9,20,null,null,15,7]
     * 示例 2:
     * 输入：inorder = [-1], postorder = [-1]
     * 输出：[-1]
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

    /**
     * Tips:
     * 后序遍历：左右中；中序遍历：左中右；
     * 通过后序遍历我们可以找到“中”；
     * 再利用这个“中”去切割中序遍历的左右区间；
     * 再利用中序遍历左区间的长度切割后序遍历的左右区间
     * */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null; // 后序遍历数组为空返回空
        // 否则拿中序和后序数组相互分割
        int rootValue = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(rootValue);
        if (postorder.length == 1) return rootNode; // 如果后序数组只有一个节点，那么直接返回这个节点
        // 利用后序来分割中序
        int index = 0;
        for ( ; index < inorder.length; index++){
            // 仅当中序数组中找到了相同的值，break，找到了中序数组的“中”
            if (inorder[index] == rootValue)
                break;
        }
        int[] leftInOrder = new int[index];
        int[] rightInOrder = new int[inorder.length - index - 1];
        // 根据中序数组，左区间为[0, index]，右区间为(index, inorder.length - 1]
        System.arraycopy(inorder, 0, leftInOrder, 0, index);
        System.arraycopy(inorder, index + 1, rightInOrder, 0, rightInOrder.length);
        // 利用中序结果来分割后序
        int[] leftPostOrder = new int[index];
        int[] rightPostOrder = new int[postorder.length - 1 - index];
        System.arraycopy(postorder, 0, leftPostOrder, 0, index);
        System.arraycopy(postorder, index, rightPostOrder, 0, rightPostOrder.length);
        rootNode.left = buildTree(leftInOrder, leftPostOrder);
        rootNode.right = buildTree(rightInOrder, rightPostOrder);
        return rootNode;
    }

    /**
     * Tips:
     * 通过前序遍历和中序遍历构造二叉树
     * 通过前序遍历的第一个值确定根节点
     * 用这个根节点切割中序数组的前后
     * 再用中序数组的前后区分前序数组的左右，进一步确认根节点
     * */
    public static TreeNode buildTreeFromPreAndPost(int[] preorder, int[] inorder) {
        // 前序：中前后，中序：前中后
        if (preorder == null || preorder.length == 0) return null;
        int rootValue = preorder[0];
        TreeNode treeNode = new TreeNode(rootValue);
        if (preorder.length == 1) return treeNode; // 只有一个节点
        // 利用前序对中序做切割
        int index = 0;
        for ( ; index < inorder.length; index++){
            if (rootValue == inorder[index]) {
                break;
            }
        }
        int[] leftInOrder = new int[index];
        int[] rightInOrder = new int[inorder.length - 1 - index];
        System.arraycopy(inorder, 0, leftInOrder, 0, leftInOrder.length);
        System.arraycopy(inorder, index + 1, rightInOrder, 0, rightInOrder.length);
        // 利用中序结果对前序做分割
        int[] leftPreOrder = new int[index];
        int[] rightPreOrder = new int[preorder.length - 1 - index];
        System.arraycopy(preorder, 1, leftPreOrder, 0, leftPreOrder.length);
        System.arraycopy(preorder, index + 1, rightPreOrder, 0, rightPreOrder.length);
//        System.out.println(Arrays.toString(leftInOrder));
//        System.out.println(Arrays.toString(rightInOrder));
//        System.out.println(Arrays.toString(leftPreOrder));
//        System.out.println(Arrays.toString(rightPreOrder));
//        System.out.println("---------------------------");
        treeNode.left = buildTreeFromPreAndPost(leftPreOrder, leftInOrder);
        treeNode.right = buildTreeFromPreAndPost(rightPreOrder, rightInOrder);
        return treeNode;
    }

    public static void preTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + ",");
        preTraversal(treeNode.left);
        preTraversal(treeNode.right);
    }
    public static void main(String[] args) {
//        中序&后序栗子
//        TreeNode treeNode = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
//        TreeNode treeNode = buildTree(new int[]{2,1}, new int[]{2,1});
//        前序&中序栗子
        TreeNode treeNode = buildTreeFromPreAndPost(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        preTraversal(treeNode);
    }
}
