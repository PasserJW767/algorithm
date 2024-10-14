import java.util.HashSet;

public class t160 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != null || pB != null){
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }

            if (pA != null){
                System.out.printf("pA.val:%d; ", (pA.val));
            } else {
                System.out.printf("pA.val:null; ");
            }
            if (pB != null){
                System.out.printf("pB.val:%d", (pB.val));
            } else {
                System.out.printf("pB.val:null");
            }
            System.out.println();

            if (pA == pB) return pA;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);
        ListNode listNode8 = new ListNode(1);
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode3;

        ListNode intersectionNode = getIntersectionNode2(listNode1, listNode6);
        System.out.println(intersectionNode.val);
    }
}
