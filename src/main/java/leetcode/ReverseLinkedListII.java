package leetcode;

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        int i = 1;
        while (i < m) {
            head = head.next;
            i++ ;
        }

        ListNode prev = head.next, cur = prev.next;
        i = 0;
        while (i < n - m) {
            prev.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = prev.next;
            i ++;
        }

        return dummy.next;
    }
}
