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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while(true){
            for(int i = 0; i < 2; i++){
                if(fast == null || fast.next == null){
                    return false;
                }

                fast = fast.next;

                if(fast == slow) {
                    return true;
                }
            }

            slow = slow.next;
        }
    }
}
