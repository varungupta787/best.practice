package leetcode;

/*  61. Rotate List */

/*  https://leetcode.com/problems/rotate-list/  */

/*
*
* Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
*
* */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }

        int size = 0, rotate = k;

        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }

        if(size == 0 || size == 1 || size == k) {
            return head;
        }

        rotate = k%size;

        if(rotate == 0) {
            return head;
        }

        curr = head;
        while((size-rotate-1) > 0) {
            curr = curr.next;
            size--;
        }
        ListNode next = curr.next;
        ListNode result = next;
        curr.next = null;
        while((rotate-1) > 0) {
            next = next.next;
            rotate--;
        }
        next.next = head;
        return result;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}