package BSTTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class t98 {
    public class TreeNode {
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
    // 判断一颗树是否为合法的BST树，就要考虑一下BST的性质
    // BST性质：根节点的左子树的值小于根节点的值；根节点的右子树的值大于根节点的值；
    // 根节点所有左子树的值均小于根节点；根节点所有右子树的值均大于根节点；
    // 考虑使用前序遍历来做：中左右，先拿取中的值，再判断左右两边的值，并不是特别合理，因为这种方法只能够判断局部的小二叉树是否合法
    // 使用中序遍历左中右来做，实际上使用中序遍历来遍历BST树的所有节点，这些节点会是单调递增的
    // 既然是单调递增的树，我们可以通过双指针法来做，判断前一个节点的值和后一个节点的值是否呈单调递增关系
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) { // cur不为空，或栈不为空
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // pre就是用来存储所谓的临时“根”节点的
                if (pre != null && cur.val <= pre.val) { // 如果不满足单调递增
                    return false;
                }
                pre = cur; // 保存前一个节点
                cur = cur.right;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        t98 obj = new t98();
        TreeNode treeNode1 = obj.new TreeNode(2);
        TreeNode treeNode2 = obj.new TreeNode(1);
        TreeNode treeNode3 = obj.new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(obj.isValidBST(treeNode1));
        TreeNode treeNode4 = obj.new TreeNode(5);
        TreeNode treeNode5 = obj.new TreeNode(1);
        TreeNode treeNode6 = obj.new TreeNode(4);
        TreeNode treeNode7 = obj.new TreeNode(3);
        TreeNode treeNode8 = obj.new TreeNode(6);
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        System.out.println(obj.isValidBST(treeNode4));
        TreeNode treeNode9 = obj.new TreeNode(5);
        TreeNode treeNode10 = obj.new TreeNode(4);
        TreeNode treeNode11 = obj.new TreeNode(6);
        TreeNode treeNode12 = obj.new TreeNode(3);
        TreeNode treeNode13 = obj.new TreeNode(7);
        treeNode9.left = treeNode10;
        treeNode9.right = treeNode11;
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        System.out.println(obj.isValidBST(treeNode9));
    }
}
