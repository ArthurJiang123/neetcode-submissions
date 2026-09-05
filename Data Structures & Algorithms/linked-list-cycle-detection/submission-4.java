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
If list has a cycle, fast pointer eventually meets with the slow pointer.
If list has no cycle, fast pointer will reach the end of the list.

Steps: 
1. slow ptr moves 1 step at a time
2. fast ptr moves 2 stpes at a time
    every time fast ptr moves, it checks if fast == slow. (has cycle)
    before fast ptr moves, it also checks if itself is null, or if its next node is null (reached the end).
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
