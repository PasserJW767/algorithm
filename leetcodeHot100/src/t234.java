public class t234 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        // 1. 找到链表的中点
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 2. 反转链表
        ListNode prev = p1;
        p1 = p1.next;
        prev.next = null;
        while (p1 != null){
            ListNode tmp = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = tmp;
        }
        // 3. 检查链表是否相同
        p1 = prev;
        p2 = head;
        while (p1 != null && p2 != null){
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(isPalindrome(listNode1));
    }
}
