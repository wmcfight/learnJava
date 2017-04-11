package leetcode;

/*
Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow;
        slow = slow.next;
        fast.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return this.mergeTwoList(l1,l2);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        int curA = Integer.MAX_VALUE, curB = Integer.MAX_VALUE;
        while (l1 != null || l2 != null) {
            curA = l1 == null ? Integer.MAX_VALUE : l1.val;
            curB = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (curA <= curB) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
