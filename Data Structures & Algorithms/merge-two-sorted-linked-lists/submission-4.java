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

        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode prev = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ListNode temp = list1.next;

                if (prev != null) prev.next = list1;
                list1.next = list2;

                prev = list1;
                list1 = temp;
            } else {
                ListNode temp = list2.next;

                if (prev != null) prev.next = list2;
                list2.next = list1;

                prev = list2;
                list2 = temp;
            }
        }

        return head;
    }
}