package leetcode;

/*  328. Odd Even Linked List   */

/*  https://leetcode.com/problems/odd-even-linked-list/ */

/*
*
* Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
*
* */


public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        ListNode even = null, curr = null, prev = null, evenHead = null;
        curr = head;

        while (curr != null) {

            if(curr.next != null) {
                prev = curr;
                if(evenHead == null) {
                    even = curr.next;
                    evenHead = even;
                } else {
                    even.next = curr.next;
                    even = even.next;
                }

                prev.next = curr.next.next;
                even.next = null;
                curr = prev.next;
            } else {
                break;
            }
        }

        if (curr == null) {
            if(prev != null) {
                prev.next = evenHead;
            }
        } else {
            curr.next = evenHead;
        }
        return head;
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