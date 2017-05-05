package leetcode;

/*
A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.


 */

/**
 * copy a linked list with random pointer
 */

/**
 * 思路，复制，解耦
 */

class RandomListNode {
  int label;
  RandomListNode next, random;
  RandomListNode(int x) { this.label = x; }
};

public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head;
        if(head == null) return head;
        RandomListNode copyhead = null;
        while(head != null){
            copyhead = head.next;
            head.next = new RandomListNode(head.label);
            head.next.next = copyhead;
            head = copyhead;
        }

        head = dummy.next;
        copyhead = head.next;
        while(copyhead != null ){
            copyhead.random = head.random == null ? null : head.random.next;
            head = copyhead.next;
            copyhead = head == null ? null : head.next;
        }

        //detach the list
        head = dummy.next;
        copyhead = head.next;
        dummy.next = copyhead;
        while(copyhead != null){
            head.next = copyhead.next;
            head = head.next;
            copyhead.next = head == null ? null : head.next;
            copyhead = copyhead.next == null ? null : copyhead.next;
        }

        return dummy.next;
    }
}
