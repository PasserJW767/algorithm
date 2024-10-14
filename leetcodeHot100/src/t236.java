import java.util.Stack;

public class t236 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后序遍历
        // 终止条件
        if (root == null) return root;
        if (root == p || root == q) return root;
        // 递归
        TreeNode treeNodeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode treeNodeRight = lowestCommonAncestor(root.right, p, q);
        if (treeNodeLeft != null && treeNodeRight != null) return root; // 说明公共节点在root
        else if (treeNodeLeft == null && treeNodeRight != null) return treeNodeRight; // 返回这个节点本身
        else if (treeNodeLeft != null && treeNodeRight == null) return treeNodeLeft;
        else return null; // 没找到p和q，返回null
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        TreeNode treeNode8 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(4);
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;
        TreeNode treeNode = lowestCommonAncestor(treeNode1, treeNode2, treeNode9);
        System.out.println(treeNode.val);
    }
}
