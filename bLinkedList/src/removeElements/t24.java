package removeElements;

public class t24 {
    /*
    * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    * 示例1：
    * 输入：head = [1,2,3,4]
    * 输出：[2,1,4,3]
    *
    * 输入：head = []
        输出：[]
    *
    * 输入：head = [1]
        输出：[1]
    *
    * */
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
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode retain = null;
        boolean flag = true;
        while (pre != null && cur != null){
            ListNode tmp = cur.next;
            pre.next = tmp;
            cur.next = pre;
            if (retain != null){
                retain.next = cur;
            }
            retain = pre;
            if (flag) {
                head = cur;
                flag = false;
            }
            pre = tmp;
            if (pre == null) continue;
            cur = tmp.next;
        }
        return head;
    }
    public static ListNode swapPairs2(ListNode head) {
        // 不需要多加一个指针retain来保留前面的信息，只需要根据后面的情况加一下判断就可以了
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = pre.next;
        boolean flag = true;
        while (pre != null && cur != null){
            ListNode tmp = cur.next;
            if (tmp == null)
                pre.next = null;
            else if (tmp != null && tmp.next == null)
                pre.next = tmp;
            else if (tmp != null && tmp.next != null)
                pre.next = tmp.next;
            cur.next = pre;
            if (flag) {
                head = cur;
                flag = false;
            }
            pre = tmp;
            if (pre == null) continue;
            cur = tmp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode listNode1 = createList2(new int[]{1,2,3,4});
        printList2(listNode1);
        ListNode result1 = swapPairs(listNode1);
        printList2(result1);
    }
}
