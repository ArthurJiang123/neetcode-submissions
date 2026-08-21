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
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (cur != list1) cur.next = list1;
                cur = list1;
                list1 = list1.next;
            } else {
                if (cur != list2) cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }

        cur.next = list1 != null ? list1 : list2;

        return head;
    }
}