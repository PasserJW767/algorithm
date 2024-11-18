import java.util.HashMap;
import java.util.Map;

public class t105 {
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

    int[] preorder;
    Map<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i); // 中序遍历，左中右
        }
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int root, int left, int right) {
        if (left > right) return null; // 递归终止
        TreeNode node = new TreeNode(preorder[root]); // 建立根节点，前序遍历中左右
        int i = dic.get(preorder[root]); // 获得这个根节点在inorder中的位置，以划分出左子树和右子树
        node.left = recur(root + 1, left, i - 1); // 新的左子树
        node.right = recur(root + i - left + 1, i + 1, right); // 新的右子树
        return node;
    }
    public static void main(String[] args) {

    }
}
