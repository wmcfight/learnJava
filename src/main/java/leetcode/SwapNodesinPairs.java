package leetcode;

/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Subscribe to see which companies asked this question.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy  = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy.next, cur = null;
        head = dummy;
        while(prev != null && prev.next != null){
            cur = prev.next;
            prev.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            head = prev;
            prev = prev.next;
        }

        return dummy.next;
    }
}
