package levelTraversal;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class t559 {
    /**
     * 给定一个 N 叉树，找到其最大深度。
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
     * 示例1：
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：3
     * 示例2：
     * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
     * 输出：5
     * */
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public static int maxDepth(Node root) {
        // 和二叉树一样，层序遍历求最大深度
        if (root == null) return 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        int maxDepth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                Node node = queue.pollFirst();
                if (node.children != null){
                    for (Node child : node.children) {
                        if (child != null) queue.add(child);
                    }
                }
                size--;
            }
            maxDepth++;
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);
        List<Node> list2 = new ArrayList<>();
        list2.add(node5);
        list2.add(node6);
        node1.children = list1;
        node2.children = list2;
        System.out.println(maxDepth(node1));
    }
}
