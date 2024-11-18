public class t437 {
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

    public static long rootSum(TreeNode root, long targetSum) {
        long ret = 0;
        if (root == null) return 0;
//        if (targetSum == 0) return 0; // 考虑反例root=[0,1,1], targetSum=0

        // 这里都是算这个root节点的情况
        long val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
    public static int pathSum(TreeNode root, int targetSum) {
        // 终止条件
        if (root == null) return 0;

        // 可能的子路径为：根节点出发的路径和+左子节点出发的路径和+右子节点出发的路径和
        long ret = rootSum(root, targetSum); // 根节点出发的路径和
        ret += pathSum(root.left, targetSum); // 左子节点出发的路径和，这个过程中可能算左子节点，可能不算左子节点
        ret += pathSum(root.right, targetSum); // 右子节点出发的路径和，这个过程中可能算右子节点，可能不算右子节点

        return (int)ret;
    }
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(10);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(-3);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(2);
        TreeNode r6 = new TreeNode(11);
        TreeNode r7 = new TreeNode(3);
        TreeNode r8 = new TreeNode(-2);
        TreeNode r9 = new TreeNode(1);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r4.left = r7;
        r4.right = r8;
        r5.right = r9;
        System.out.println(pathSum(r1, 8));

    }
}
