package leetcode;

/*  82. Remove Duplicates from Sorted List II   */

/*  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/    */

/*
*
* Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]

*
* */

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head, prev = null;
        boolean isDuplicate = false;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                isDuplicate = true;
                ListNode next = head.next;
                head.next = head.next.next;
                next.next = null;
            } else if (isDuplicate) {
                if (prev == null) {
                    ListNode next = head.next;
                    head.next = null;
                    head = next;
                    curr = head;
                } else {
                    ListNode next = head.next;
                    prev.next = next;
                    head.next = null;
                    head = next;
                }
                isDuplicate = false;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return curr;
    }

    static public class ListNode {
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
