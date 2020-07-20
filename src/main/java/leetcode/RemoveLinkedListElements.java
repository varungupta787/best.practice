package leetcode;

/*  203. Remove Linked List Elements    */

/*  https://leetcode.com/problems/remove-linked-list-elements/  */

/*
*
* Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*
* */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode out = null;
        if(head == null)
            return out;
        ListNode prev = null;
        while(head != null) {
            if(head.val == val) {
                if(prev != null) {
                    prev.next = head.next;
                }
            } else {
                prev = head;
                if(out == null) {
                    out = head;
                }
            }
            head = head.next;
        }
        return out;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
