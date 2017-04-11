package leetcode;

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        n = n%len;
        ListNode prev = dummy,cur = null;
        head = dummy;
        for(int i=0;i<len-n;i++){
            prev = prev.next;
        }
        cur = prev.next;
        while(cur != null){
            prev.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = prev.next;
            head = head.next;
        }

        return dummy.next;
    }
}
