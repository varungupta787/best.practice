package leetcode;

/*  234. Palindrome Linked List */

/*  https://leetcode.com/problems/palindrome-linked-list/   */

/*
*
* Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*
* */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;

        while(true) {
            if(fast.next == null ||
                    fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode last = reverseList(slow, slow.next);
        return isPalindrome(head, last);
    }

    private boolean isPalindrome(ListNode start, ListNode end) {
        while(start != end) {
            if(start.val != end.val) {
                return false;
            }
            if(start.next == end) {
                break;
            }
            start = start.next;
            end = end.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode prev, ListNode node) {

        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }


    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
