import java.util.Stack;

public class t114 {
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
    public void flatten(TreeNode root) {
        while (root != null) {
            // 如果左子树为null，则直接考虑右子树
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右侧节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将原来右子树接到左子树最右的节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
    public static void main(String[] args) {

    }
}
