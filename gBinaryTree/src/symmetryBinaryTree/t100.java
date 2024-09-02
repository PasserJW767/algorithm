package symmetryBinaryTree;

public class t100 {
    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
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
    // 自己写的错误方法
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p !=null && q == null)) return false; // 其中一个不为空，返回false
        if (p == null && q == null) return true;
        if (p.val != q.val) return false;
        // 判断两棵树是否相同，就要判断其左子树和右子树是否相同
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(isSameTree(treeNode1, treeNode1));

//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(1);
//        TreeNode treeNode4 = new TreeNode(2);
//        treeNode1.left = treeNode2;
//        treeNode3.right = treeNode4;
//        System.out.println(isSameTree(treeNode1, treeNode3));
    }
}
