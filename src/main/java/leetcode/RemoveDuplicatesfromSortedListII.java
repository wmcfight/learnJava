package leetcode;

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.


 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, cur = prev.next;
        while(cur != null && cur.next != null){
            if(prev.next.val == cur.next.val){
                while(cur.next != null && prev.next.val == cur.next.val){
                    cur = cur.next;
                }
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = prev.next;
                cur = cur.next;
            }

        }

        return dummy.next;
    }
}
