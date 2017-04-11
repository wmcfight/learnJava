package leetcode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curNode = result;
        int cur1, cur2;
        int sum, prev = 0;
        while (l1 != null || l2 != null) {
            cur1 = l1 == null ? 0 : l1.val;
            cur2 = l2 == null ? 0 : l2.val;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            sum = cur1 + cur2 + prev;
            prev = sum/10;
            curNode.next = new ListNode(sum%10);
            curNode = curNode.next;
        }
        if(prev > 0){
            curNode.next = new ListNode(prev);
        }
        return result.next;
    }
}
