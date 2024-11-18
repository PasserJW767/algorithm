public class t2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 新链表存储结果
        ListNode cur = dummy;
        int carry = 0; // 记录进位
        while (l1 != null || l2 != null || carry != 0) { // 若链表不为空，或进位不为空，就需要继续计算
            if (l1 != null) {
                carry += l1.val; // 节点值和进位值相加
                l1 = l1.next; // 下一个节点
            }
            if (l2 != null) {
                carry += l2.val; // 节点值+进位值
                l2 = l2.next;
            }
            cur.next = new ListNode(carry % 10); // 10进1~余数就是在这位上的结果
            cur = cur.next; // 当前指针进行移动
            carry /= 10; // 新的进位结果
        }
        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
