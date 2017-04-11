package leetcode;

/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head, slow = fast.next;
        while(slow != null && slow.next != null){
            if(fast == slow){
                return true;
            }
            slow = slow.next.next;
            fast = fast.next;
        }
        return false;

    }
}
