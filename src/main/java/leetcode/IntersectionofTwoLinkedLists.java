package leetcode;


/**
 * 解题思路：
 * 先求出两个链表各自长度，然后对齐，然后依次比较
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.

 */
public class IntersectionofTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode dummyA = new ListNode(-1), dummyB = new ListNode(-1);
        ListNode result = null;
        dummyA.next = headA;
        dummyB.next = headB;
        int lenA = 0;
        int lenB = 0;
        while (headA != null) {
            lenA++;
            headA = headA.next;
        }
        while (headB != null) {
            lenB++;
            headB = headB.next;
        }
        headA = dummyA.next;
        headB = dummyB.next;
        int gap = Math.abs(lenA - lenB);
        int i = 0;
        while(i < gap) {
            headA = lenA > lenB ? headA.next : headA;
            headB = lenB > lenA ? headB.next : headB;
            i++;
        }

        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                result =  headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }


        return result;
    }
}
