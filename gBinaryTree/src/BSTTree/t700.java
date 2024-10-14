package BSTTree;

public class t700 {
    /**
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
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
    public TreeNode searchBST(TreeNode root, int val) {
        // 二叉搜索树的性质就是左边小右边大
        if (root == null) return null;
        if (root.val == val){
            return root;
        } else if (root.val < val) { // 当前节点的值小于目标值，向右搜索
            return searchBST(root.right, val);
        } else { // 当前节点的值大于目标值，向左搜索
            return searchBST(root.left, val);
        }
    }
    public static void main(String[] args) {
        t700 obj = new t700();
        TreeNode treeNode1 = obj.new TreeNode(4);
        TreeNode treeNode2 = obj.new TreeNode(2);
        TreeNode treeNode3 = obj.new TreeNode(7);
        TreeNode treeNode4 = obj.new TreeNode(1);
        TreeNode treeNode5 = obj.new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        System.out.println(obj.searchBST(treeNode1, 2).val);
    }
}
