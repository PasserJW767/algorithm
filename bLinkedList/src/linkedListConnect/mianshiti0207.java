package linkedListConnect;

import removeNodeTheEndOfLinkedList.t19;

public class mianshiti0207 {
    /*
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * 题目数据 保证 整个链式结构中不存在环。
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     *
     * 示例1：
     *  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
        输出：Intersected at '8'
        解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
        从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
        在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *
     * 示例2：
        输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
        输出：Intersected at '2'
        解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
        从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
        在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0, bLength = 0;
        ListNode curA = headA, curB = headB;
        // 求List A和 List B的长度
        while (curA != null){
            aLength++;
            curA = curA.next;
        }
        while (curB != null){
            bLength++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 将a移动到aLength - bLength处
        if (aLength > bLength){
            for (int i = 0; i < aLength - bLength; i++) {
                curA = curA.next;
            }
        } else { // 将b移动到bLength - aLength处
            for (int i = 0; i < bLength - aLength; i++){
                curB = curB.next;
            }
        }
        while (curA != null){
            if (curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
    public static void main(String[] args) {
    }
}
