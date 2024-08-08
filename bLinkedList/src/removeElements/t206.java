package removeElements;

public class t206 {
    /*
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode createList2(int[] nums){
        ListNode result = new ListNode();
        if (nums.length == 0) return result;
        ListNode point = result;
        result.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ListNode ln = new ListNode(nums[i]);
            point.next = ln;
            point = point.next;
        }
        return result;
    }
    public static void printList2(ListNode ln){
        while (ln != null){
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
        System.out.println();
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode listNode1 = createList2(new int[]{1,2,3,4,5});
        printList2(listNode1);
        ListNode result1 = reverseList(listNode1);
        printList2(result1);
    }
}
