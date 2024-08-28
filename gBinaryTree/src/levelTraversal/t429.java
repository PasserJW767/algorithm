package levelTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class t429 {
    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     *
     * 示例1：
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[[1],[3,2,4],[5,6]]
     *
     * 示例2：
     * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
     * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
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
    }
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<Node> deque = new ArrayDeque<>();
        Node cur = root;
        deque.addLast(cur);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelResult = new ArrayList<>();
            while (size > 0){
                cur = deque.pollFirst();
                levelResult.add(cur.val);
                if (cur.children != null){
                    for (Node child : cur.children) {
                        if (child != null) deque.addLast(child);
                    }
                }
                size--;
            }
            result.add(levelResult);
        }
        return result;
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
        node1.children = list1;
        List<Node> list2 = new ArrayList<>();
        list2.add(node5);
        list2.add(node6);
        node2.children = list2;
        node3.children = null;
        node4.children = null;
        node5.children = null;
        node6.children = null;
        System.out.println(levelOrder(node1));
    }
}
