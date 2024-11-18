import java.util.PriorityQueue;

public class t23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // 小根堆排大小
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0), cur = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            cur = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {

    }
}
