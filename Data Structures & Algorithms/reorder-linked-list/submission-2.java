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
     * - Recursively reach the end first.
     * - Then start inserting the last node after the first, then
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
        
        // After reaching the end, return the head.
        if (back == null) return front;

        // Recursively reach the last node.
        // Then, get the front node.
        front = reorder(front, back.next);

        // A null was returned when the middle was reached. 
        // Keep returning null to terminate all recursions.
        if (front == null) return null;

        // Stop when front and back meet (odd) or are adjacent (even)
        // set the last back node's next to null to avoid circles.
        if(front == back || front.next == back){
            back.next = null;
            return null;
        }

        // front -> back -> nextFront
        ListNode frontNext = front.next;
        front.next = back;
        back.next = frontNext;
        // return the next front node to be processed
        return frontNext;
    }
}