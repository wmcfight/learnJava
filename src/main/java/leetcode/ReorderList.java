package leetcode;

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.


 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode fdummy = new ListNode(-1);
        fdummy.next = head;
        ListNode slow = head, fast = slow.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;
        fast = reverseList(fast);
        slow = fdummy.next;
        while(fast != null){
            ListNode stemp = slow.next;
            ListNode ftemp = fast.next;
            slow.next = fast;
            fast.next = stemp;
            slow = stemp;
            fast = ftemp;
        }
    }

    public ListNode reverseList(ListNode head){

        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy.next, cur =prev.next;
        head = dummy;
        while(cur != null){
            prev.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = prev.next;
        }

        return dummy.next;
    }
}
