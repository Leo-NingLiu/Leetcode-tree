/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        int leftDepth = maxDepth(root.left); // use recursion to find the max depth
        int rightDepth = maxDepth(root.right);
        int res = Math.max(leftDepth, rightDepth) + 1; // plus 1 represents the root level
        return res;
    }
}
