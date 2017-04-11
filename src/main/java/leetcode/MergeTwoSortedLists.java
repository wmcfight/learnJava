package leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        int cl1V = 0, cl2V = 0;
        while(l1 != null || l2 != null) {
            cl1V = l1 == null ? Integer.MAX_VALUE : l1.val;
            cl2V = l2 == null ? Integer.MAX_VALUE : l2.val;
            cur.next = new ListNode(Math.min(cl1V, cl2V));
            cur = cur.next;
            l1 = cl1V <= cl2V ? l1.next : l1;
            l2 = cl1V <= cl2V ? l2 : l2.next;
        }
        return dummy.next;
    }
}
