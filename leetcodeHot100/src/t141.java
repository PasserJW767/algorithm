public class t141 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
