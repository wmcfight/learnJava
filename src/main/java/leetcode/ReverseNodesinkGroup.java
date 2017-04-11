package leetcode;

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Subscribe to see which companies asked this question
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<=0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        ListNode prev = dummy.next,cur = null;
        head = dummy;

        while(prev != null && prev.next != null){
            if(len < k) break;
            int i = 1;
            cur = prev.next;
            while(i<k && cur != null){
                prev.next = cur.next;
                cur.next = head.next;
                head.next = cur;
                cur = prev.next;
                i++;
            }
            head = prev;
            prev = prev.next;
            len -= k;
        }
        return dummy.next;
    }
}
