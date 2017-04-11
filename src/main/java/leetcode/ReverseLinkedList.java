package leetcode;

/*
Reverse a singly linked list.
 */
//头插法
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            // KEY POINT
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }



    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
