package leetcode;

/*  143. Reorder List   */

/*  https://leetcode.com/problems/reorder-list/ */

/*
*
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*
* */

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;


        ListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        slow = head;
        ListNode secondHalf = preMiddle.next;
        while (slow != preMiddle) {
            preMiddle.next = secondHalf.next;
            secondHalf.next = slow.next;
            slow.next = secondHalf;
            slow = secondHalf.next;
            secondHalf = preMiddle.next;
        }
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
