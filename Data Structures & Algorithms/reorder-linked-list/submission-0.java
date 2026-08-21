/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    /*
     * Approach: Recursion
     *
     * - Recursively reach the end so the list is handled from right to left.
     * - Starting from the head, insert the last node after the first, then
         the second-last after the second, continuing toward the middle.
     * - End the list when the two sides meet.
     *
     * Time: O(n)
     * Space: O(n)
    */
    
    public void reorderList(ListNode head) {
        reorder(head, head);
    }

    private ListNode reorder(ListNode front, ListNode back) {
        // base case: Reached the end.
        if (back == null) return front;

        // Recursively reach the last node before reordering.
        front = reorder(front, back.next);

        // A null was returned because the middle was reached. 
        // Keep returning null to terminate all recursions.
        if (front == null) return null;

        // Stop when front and back meet (odd) or are adjacent (even)
        if (front == back || front.next == back) {
            back.next = null;
            return null;
        }

        // front -> back -> nextFront
        ListNode nextFront = front.next;
        front.next = back;
        back.next = nextFront;

        return nextFront;
    }
}