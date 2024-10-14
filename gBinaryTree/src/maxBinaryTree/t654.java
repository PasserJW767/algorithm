package maxBinaryTree;

public class t654 {
    /**
     * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
     * 创建一个根节点，其值为 nums 中的最大值。
     * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
     * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
     * 返回 nums 构建的 最大二叉树 。
     * https://leetcode.cn/problems/maximum-binary-tree/description/
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]); // 提升速度
        // 找到最大数值的那个index，并区分出左右
        int max = -1;
        int index = 0;
        for (int i = 0 ; i < nums.length; i++){
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        // 最大值作为根节点
        TreeNode root = new TreeNode(nums[index]);
        // 区分左右节点
        int[] leftNums = new int[index];
        int[] rightNums = new int[nums.length - 1 - index];
        System.arraycopy(nums, 0, leftNums, 0, leftNums.length);
        System.arraycopy(nums, index + 1, rightNums, 0, rightNums.length);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;
    }

    public void traversal(TreeNode treeNode) {
        if (treeNode == null){
            return;
        }
        System.out.print(treeNode.val + ",");
        traversal(treeNode.left);
        traversal(treeNode.right);
    }
    public static void main(String[] args) {
        t654 obj = new t654();
        TreeNode treeNode = obj.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        obj.traversal(treeNode);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
        System.out.println(treeNode.left.right.val);
        System.out.println(treeNode.left.right.right.val);
        System.out.println(treeNode.right.left.val);
    }
}
