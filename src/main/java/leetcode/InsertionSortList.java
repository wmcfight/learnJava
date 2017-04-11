package leetcode;

/*
Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1), cur = dummy.next, prev = dummy;
        while (head != null) {
            cur = dummy.next;
            prev = dummy;
            while (cur != null) {
                if (cur.val < head.val) {
                    prev = cur;
                    cur = cur.next;
                } else  {
                    break;
                }
            }
            prev.next = cur;
            prev.next = new ListNode(head.val);
            prev.next.next = cur;

            head = head.next;
        }
        return dummy.next;
    }
}
