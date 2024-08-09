package removeNodeTheEndOfLinkedList;

import removeElements.t203;
import reverseLinkedList.t206;

public class t19 {
    /*
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 示例 1：
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
     *
     * 示例 2：
        输入：head = [1], n = 1
        输出：[]
     *
     * 示例 3：
        输入：head = [1,2], n = 1
        输出：[1]
     *
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        // 目标就是size - n - 1个节点(下标size - n)，删除这个节点
        // 建立虚拟的头结点，避免头结点删除
        ListNode nh = new ListNode();
        nh.next = head;
        curr = nh;
        for (int i = 0; i < size - n; i++){
            assert curr != null;
            curr = curr.next;
        }
        assert curr != null;
        if (curr.next != null){
            curr.next = curr.next.next;
        } else{
            curr.next = null;
        }
        return nh.next;
    }
    public static ListNode removeNthFromEndFS(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        // 快指针先移动n步
        int count = 0;
        while (count < n){
            count++;
            fast = fast.next;
        }
        // 快慢指针同时移动，直到快指针指向了最后一个节点，可以使用慢指针进行删除
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
    public static void main(String[] args) {
//        ListNode listNode1 = createList2(new int[]{1,2,3,4,5});
//        printList2(listNode1);
//        ListNode listNode2 = removeNthFromEndFS(listNode1, 2);
//        printList2(listNode2);
//        ListNode listNode1 = createList2(new int[]{1,2});
//        printList2(listNode1);
//        ListNode listNode2 = removeNthFromEndFS(listNode1, 1);
//        printList2(listNode2);
//        ListNode listNode1 = createList2(new int[]{1});
//        printList2(listNode1);
//        ListNode listNode2 = removeNthFromEndFS(listNode1, 1);
//        printList2(listNode2);
        ListNode listNode1 = createList2(new int[]{1,2});
        printList2(listNode1);
        ListNode listNode2 = removeNthFromEndFS(listNode1, 2);
        printList2(listNode2);

    }
}
