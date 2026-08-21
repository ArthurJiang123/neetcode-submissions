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

 
/*
 * Approach: In-Place Merge
 *
 * Since both lists are sorted, merge them by choosing the smaller
 * current node each time. Reuse the original nodes and rearrange
 * their next pointers instead of creating new nodes.
 *
 * Time: O(n + m)
 * Space: O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Keep the first node so the merged list can be returned at the end.
        ListNode head = list1.val <= list2.val ? list1 : list2;

        // Tracks the last node already placed in sorted order.
        ListNode prev = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // Save the rest of list1 before changing its next pointer.
                ListNode temp = list1.next;

                if (prev != null) prev.next = list1;
                list1.next = list2;

                // list1 is now the last node placed in sorted order.
                prev = list1;
                list1 = temp;
            } else {
                // Save the rest of list2 before changing its next pointer.
                ListNode temp = list2.next;

                if (prev != null) prev.next = list2;
                list2.next = list1;

                // list2 is now the last node placed in sorted order.
                prev = list2;
                list2 = temp;
            }
        }

        return head;
    }
}