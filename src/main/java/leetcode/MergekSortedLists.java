package leetcode;

import java.util.PriorityQueue;

/*  23. Merge k Sorted Lists    */

/*  https://leetcode.com/problems/merge-k-sorted-lists/ */

/*
*
* You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
*
* */

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode currNode = head;
        if(lists == null || lists.length == 0) {
            return head.next;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b)-> a.val-b.val);
        for(ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            ListNode node = queue.remove();
            currNode.next = node;
            currNode = node;
            if(node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
