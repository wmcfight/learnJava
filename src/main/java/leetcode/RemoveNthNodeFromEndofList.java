package leetcode;

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        n = n%len;
        n = n==0?1:len-n+1;
        head = dummy;
        for(int i=1;i<n;i++){
            head = head.next;
        }
        head.next = head.next.next;

        return dummy.next;

    }
}
