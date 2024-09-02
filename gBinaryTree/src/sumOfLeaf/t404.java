package sumOfLeaf;

public class t404 {
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
    public static int sumOfLeftLeaves(TreeNode root) {
        // 感觉可以用中左右、左右中、左中右都可以，三种遍历方式都可以。那我用前序遍历中左右吧
        int result = 0;
        if (root.left != null){
            if (root.left.left == null && root.left.right == null) result += root.left.val;
            else result += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) result += sumOfLeftLeaves(root.right);
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
        System.out.println(sumOfLeftLeaves(treeNode1));
    }
}
