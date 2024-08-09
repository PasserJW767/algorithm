package cycleLinkedList;

import linkedListConnect.mianshiti0207;

public class t142 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode createList2(int[] nums, int pos){
        ListNode result = new ListNode();
        if (nums.length == 0) return result;
        ListNode point = result;
        result.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ListNode ln = new ListNode(nums[i]);
            point.next = ln;
            point = point.next;
        }
        ListNode cur = result;
        for (int i = 0; i < pos; i++){
            cur = cur.next;
        }
        point.next = cur;
        return result;
    }
    public static void printList2(ListNode ln){
        while (ln != null){
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
        System.out.println();
    }
    public static ListNode detectCycle(ListNode head) {
        // slow一步, fast两步，直到探测到环
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇说明有环
            if (fast == slow){
                ListNode cur = head;
                while (cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode ln1 = createList2(new int[]{3,2,0,-4}, 1);
        System.out.println(detectCycle(ln1).val);
    }
}
