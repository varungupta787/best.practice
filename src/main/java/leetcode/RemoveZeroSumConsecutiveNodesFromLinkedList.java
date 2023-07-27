package leetcode;


/*  https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/   */

/*  1171. Remove Zero Sum Consecutive Nodes from Linked List    */

/*
*
* Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.



(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
*
* */

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode root = head, prev = null;
        HashMap<Integer, ListNode> temp = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        root = dummy;
        int sum = 0;
        while (root != null) {
            sum += root.val;
            temp.put(sum, root);
            root = root.next;
        }
        sum = 0;
        root = dummy;
        while (root != null) {
            sum += root.val;
            root.next = temp.get(sum).next;
            root = root.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
