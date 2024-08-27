package traversal;

import com.sun.source.tree.Tree;

import java.util.*;

public class t107levelOrderBottomTraversal {
    /**
     * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
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
     * 反转前序遍历
     * */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        return result.reversed();
    }
    /**
     * 用三个栈，不反转得到结果
     * */
    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> tmpStack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TreeNode cur = root;
        stack1.push(root);
        while (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                cur = stack1.pop(); // 从栈1中弹出元素
                stack2.push(cur.val); // 元素值压入栈2
                if (cur.right != null) tmpStack.push(cur.right); // 右孩子入临时栈
                if (cur.left != null) tmpStack.push(cur.left); // 左孩子入临时栈
            }
            stack2.push(null);
            // 将临时栈中的元素压入栈1
            while (!tmpStack.isEmpty()){
                stack1.push(tmpStack.pop());
            }
        }
        // 将stack2中的值写出
        while (!stack2.isEmpty()) {
            stack2.pop(); // 弹出一个空值
            List<Integer> levelResult = new ArrayList<>();
            while (!stack2.isEmpty() && stack2.peek() != null){
                Integer value = stack2.pop();
                levelResult.add(value);
            }
            result.add(levelResult);
        }
        return result;
    }
    /**
     * 不用三个栈了，用一个队列和一个栈，类似于前序遍历的做法
     * */
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack2 = new Stack<>();
        TreeNode cur = root;
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                cur = queue.pollFirst();
                stack2.push(cur.val); // 元素值压入栈2
                if (cur.right != null) queue.addLast(cur.right); // 右孩子入临时栈
                if (cur.left != null) queue.addLast(cur.left); // 左孩子入临时栈
                size--;
            }
            stack2.push(null);
        }
        // 将stack2中的值写出
        while (!stack2.isEmpty()) {
            stack2.pop(); // 弹出一个空值
            List<Integer> levelResult = new ArrayList<>();
            while (!stack2.isEmpty() && stack2.peek() != null){
                Integer value = stack2.pop();
                levelResult.add(value);
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
        System.out.println(levelOrderBottom2(treeNode1));
    }
}
