package leetcode;

/*  83. Remove Duplicates from Sorted List  */

/*  https://leetcode.com/problems/remove-duplicates-from-sorted-list/   */

/*
*
* Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
*
* */



public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                ListNode next = head.next;
                head.next = head.next.next;
                next.next = null;
            } else {
                head = head.next;
            }
        }
        return curr;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  }
}
