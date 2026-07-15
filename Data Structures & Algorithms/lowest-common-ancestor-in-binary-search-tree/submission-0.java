/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
    - BST: left child < parent < right child
    - The LCA is the node where p and q split path: one goes left, the other goes right 
      (or the node itself equals p or q).
    Solution:
    1. Walk down from root. 
    2. If both values are smaller, go left. 
    3. If both are larger, go right. Otherwise, you're at the split point (LCA).
    */

    // time: O(h)
    // space: O(h) for recursion stack
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
        return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
