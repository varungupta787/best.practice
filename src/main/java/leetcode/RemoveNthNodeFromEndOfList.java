package leetcode;

/*  19. Remove Nth Node From End of List    */

/*  https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */

/*
*
* Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*
* */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = head;
        ListNode fast, slow;
        fast = head;
        slow = head;

        for(int i=0; i<n; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            return slow.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast= fast.next;
        }
        slow.next = slow.next.next;
        return start;
    }

    static  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
