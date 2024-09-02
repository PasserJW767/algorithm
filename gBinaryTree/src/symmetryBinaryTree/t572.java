package symmetryBinaryTree;

public class t572 {
    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     * 示例1：
     * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
     * 输出：true
     * 示例2：
     * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
     * 输出：false
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
    public static boolean isSubtree_incorrect(TreeNode root, TreeNode subRoot) {
        if ((root == null && subRoot != null) || (root != null && subRoot == null)) return false;
        if (root == null && subRoot == null) return true;
        boolean left, right;
        if (root.val != subRoot.val){
//            left = isSubtree(root.left, subRoot);
//            right = isSubtree(root.right, subRoot);
            boolean value1 = isSubtree_incorrect(root.left, subRoot) || isSubtree_incorrect(root.right, subRoot);
            boolean value2 = isSubtree_incorrect(root.left, subRoot.left) || isSubtree_incorrect(root.right, subRoot.right);
            return value1 || value2;
        } else {
            if (subRoot.left == null && subRoot.right == null) return true;
            left = isSubtree_incorrect(root.left, subRoot.left);
            right = isSubtree_incorrect(root.right, subRoot.right);
            return left && right;
        }
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if ((root == null && subRoot != null) || (root != null && subRoot == null)) return false;
        if (root == null && subRoot == null) return true;
        if (root.val == subRoot.val){
            return isSameTree(root,subRoot);
        } else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
//        // 判断root树的左子树和sub是否一致
//        // 判断root树的右子树和sub是否一致
//        // 判断当前root树和sub树是否一致
//        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root,subRoot);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if ((p == null && q != null) || (p !=null && q == null)) return false; // 其中一个不为空，返回false
        if (p == null && q == null) return true;
        if (p.val != q.val) return false;
        // 判断两棵树是否相同，就要判断其左子树和右子树是否相同
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(5);
//        TreeNode treeNode4 = new TreeNode(1);
//        TreeNode treeNode5 = new TreeNode(2);
//        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(1);
//        TreeNode treeNode8 = new TreeNode(2);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode6.left = treeNode7;
//        treeNode6.right = treeNode8;
//        System.out.println(isSubtree(treeNode1, treeNode6));

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(0);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.left = treeNode9;
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        System.out.println(isSubtree(treeNode1, treeNode6));
    }
}
