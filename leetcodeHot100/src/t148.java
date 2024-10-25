import java.util.List;

public class t148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode sortList(ListNode head) {
        // 归并排序

        // 返回条件
        if (head == null) return head;
        if (head != null && head.next == null) return head;

        // 切左右
        ListNode prevSlowNode = head;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            prevSlowNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        prevSlowNode.next = null;

        // 排左右
        ListNode leftNode = sortList(head); // 排左边
        ListNode rightNode = sortList(slowNode); // 排右边

        // 左右归并排序
        ListNode result = new ListNode(); // dummy head
        ListNode cur = result;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val){
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode = rightNode.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if (leftNode != null){
            cur.next = leftNode;
        }
        if (rightNode != null){
            cur.next = rightNode;
        }

        return result.next;
    }
    public static ListNode sortListOn2(ListNode head) {
        // O(n)的空间复杂度
        ListNode result_head = new ListNode();
        ListNode result_tail = result_head;

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // O(n^2)的时间复杂度
        while (dummyHead.next != null){
            // 查找最小值节点
            ListNode prevNode = dummyHead;
            ListNode curNode = dummyHead.next;
            ListNode minNode_prev = null;
            ListNode minNode = null;
            while (curNode != null){
                if (minNode == null || curNode.val < minNode.val) {
                    minNode_prev = prevNode;
                    minNode = curNode;
                }
                prevNode = prevNode.next;
                curNode = curNode.next;
            }
            // 断开minNode和原始链表的连接
            minNode_prev.next = minNode.next;
            // 将minNode接入新链表
            result_tail.next = minNode;
            minNode.next = null;
            result_tail = minNode;
        }
        return result_head.next;
    }
    public static void printList(ListNode result){
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode result = sortList(listNode1);
        printList(result);
        sortList(null);
    }
}
