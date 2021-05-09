package leetcode;

/*
*
*   24. Swap Nodes in Pairs
*
*   https://leetcode.com/problems/swap-nodes-in-pairs/
*
*
* Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)



Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
*
* */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        boolean swap = true;
        ListNode curr = head, prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            if(swap) {
                if(prev == null) {
                    curr.next = next.next;
                    next.next = curr;
                    head = next;
                } else {
                    if(next != null) {
                        prev.next = next;
                        curr.next = next.next;
                        next.next = curr;
                    } else {
                        break;
                    }
                }
            }
            if(swap) {
                prev = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
            swap = !swap;
        }
        return head;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
