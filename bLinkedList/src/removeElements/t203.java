package removeElements;

public class t203 {
//     Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 我自己定义的头结点是不存储数据的。。见createList和printList
    public static ListNode createList(int[] nums){
        ListNode result = new ListNode();
        ListNode point = result;
        for (int i = 0; i < nums.length; i++) {
            ListNode ln = new ListNode(nums[i]);
            point.next = ln;
            point = point.next;
        }
        return result;
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
    // LeetCode上定义的头结点是存储数据的。。见createList和printList
    public static void printList(ListNode ln){
        while (ln.next != null){
            ln = ln.next;
            System.out.print(ln.val + " ");
        }
        System.out.println();
    }
    public static void printList2(ListNode ln){
        while (ln != null){
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
        System.out.println();
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode points = head;
        while (points != null && points.next != null){
            if (points.next.val == val){
                points.next = points.next.next;
            }
            else {
                points = points.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode listNode1 = createList2(new int[]{1,2,6,3,4,5,6});
        printList2(listNode1);
        ListNode result1 = removeElements(listNode1, 6);
        printList2(result1);
        System.out.println("------------------------");
        ListNode listNode2 = createList2(new int[]{});
        printList2(listNode2);
        ListNode result2 = removeElements(listNode2, 1);
        printList2(result2);
        System.out.println("------------------------");
        ListNode listNode3 = createList2(new int[]{7,7,7,7});
        printList2(listNode3);
        ListNode result3 = removeElements(listNode3, 7);
        printList2(result3);
    }
}
