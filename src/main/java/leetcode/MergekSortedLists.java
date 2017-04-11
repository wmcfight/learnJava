package leetcode;

import java.util.ArrayList;

/*

 */
public class MergekSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = null;
        for(ListNode iter :lists){
            head = mergeTwoLists(head,iter);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        int aval = 0, bval = 0;
        ListNode dummy = new ListNode(-1),head = dummy;
        while(l1 != null || l2 != null){
            aval = l1 == null ? java.lang.Integer.MAX_VALUE : l1.val;
            bval = l2 == null ? java.lang.Integer.MAX_VALUE : l2.val;
            head.next = aval < bval ? l1 : l2;
            head = head.next;
            l1 = aval < bval ? l1.next: l1;
            l2 = aval < bval ? l2 : l2.next;
        }
        return dummy.next;
    }
}
