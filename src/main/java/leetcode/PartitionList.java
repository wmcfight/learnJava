package leetcode;

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lDummy = new ListNode(-1), sDummy = new ListNode(-1);
        ListNode lCur = lDummy, sCur = sDummy;
        while (head != null) {
            if (head.val < x) {
                sCur.next = head;
                sCur = sCur.next;
            } else {
                lCur.next = head;
                lCur = lCur.next;
            }
            head = head.next;
        }

        sCur.next = lDummy.next;
        lCur.next = null;
        return sDummy.next;
    }
}
