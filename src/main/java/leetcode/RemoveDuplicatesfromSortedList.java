package leetcode;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, cur = head.next;
        while (cur != null ) {
            if (cur.val != prev.val) {
                prev.next = cur;
                prev = cur;
            }
            cur = cur.next;
        }
        prev.next = null;

        return head;
    }
}
