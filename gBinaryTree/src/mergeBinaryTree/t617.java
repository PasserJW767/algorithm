package mergeBinaryTree;

import maxBinaryTree.t654;

public class t617 {
    /**
     * 给你两棵二叉树： root1 和 root2 。
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
     * 返回合并后的二叉树。
     * 注意: 合并过程必须从两个树的根节点开始。
     * */
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 前序遍历，中左右来做吧
        if (root1 == null && root2 == null) return null;
        if (root1 == null && root2 != null) {
            TreeNode treeNode = new TreeNode(root2.val);
            treeNode.left = mergeTrees(null, root2.left);
            treeNode.right = mergeTrees(null, root2.right);
            return treeNode;
        }
        if (root1 != null && root2 == null) {
            TreeNode treeNode = new TreeNode(root1.val);
            treeNode.left = mergeTrees(root1.left, null);
            treeNode.right = mergeTrees(root1.right, null);
            return treeNode;
        }
        // 先默认root1和root2都有值的情况
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    public void traversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + ",");
        traversal(treeNode.left);
        traversal(treeNode.right);
    }
    public static void main(String[] args) {
        t617 obj = new t617();

        TreeNode a1 = obj.new TreeNode(1);
        TreeNode a2 = obj.new TreeNode(3);
        TreeNode a3 = obj.new TreeNode(2);
        TreeNode a4 = obj.new TreeNode(5);
        a1.left = a2;
        a2.left = a4;
        a1.right = a3;

        TreeNode b1 = obj.new TreeNode(2);
        TreeNode b2 = obj.new TreeNode(1);
        TreeNode b3 = obj.new TreeNode(4);
        TreeNode b4 = obj.new TreeNode(3);
        TreeNode b5 = obj.new TreeNode(7);
        b1.left = b2;
        b1.right = b4;
        b2.right = b3;
        b4.right = b5;

        TreeNode result = obj.mergeTrees(a1, b1);
        obj.traversal(result);
    }
}
