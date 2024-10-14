import java.util.ArrayDeque;
import java.util.Deque;

public class t226 {
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
    public static TreeNode invertTree(TreeNode root) {
        // 应该是DFS后回溯，后序遍历，左右中（在中交换）

        // 终止条件
        if (root == null) return null;

        // 后序遍历
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        // 中间节点交换
        TreeNode tmp = leftNode;
        root.left = rightNode;
        root.right = tmp;
        // 交换结束返回root
        return root;
    }
    public static void cengxubianli(TreeNode root){
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            TreeNode popElem = deque.removeFirst();
            System.out.print(popElem.val + ",");
            if (popElem.left != null) deque.addLast(popElem.left);
            if (popElem.right != null) deque.addLast(popElem.right);
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        cengxubianli(treeNode1);
        System.out.println();
        TreeNode root = invertTree(treeNode1);
        cengxubianli(root);
    }
}
