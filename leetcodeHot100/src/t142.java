public class t142 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                ListNode cur = head;
                while (cur != slowNode) {
                    cur = cur.next;
                    slowNode = slowNode.next;
                }
                return cur;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
