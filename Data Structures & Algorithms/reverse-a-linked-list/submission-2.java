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
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null) return head;

        ListNode newHead = reverse(null, head);
        return newHead;
    }

    private ListNode reverse(ListNode prev, ListNode curr){
        ListNode head;
        if(curr.next != null){
            head = reverse(curr, curr.next);
        } else {
            curr.next = prev;
            return curr;
        }

        curr.next = prev;
        return head;
    }
}
