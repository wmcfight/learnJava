package leetcode;

import java.util.HashSet;

/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(!findCycle(head)) return null;
        HashSet<ListNode> dset = new HashSet<ListNode>();

        while(head != null){
            if(dset.contains(head)){
                break;
            }else{
                dset.add(head);
            }
            head = head.next;
        }
        return head;
    }

    public boolean findCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head,fast = slow.next;
        while(fast != null && fast.next != null){
            if(fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
