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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean flag = false;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int sub = Math.abs(left - right);
        return (sub <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int maxDepth(TreeNode node) {
        if(node == null) return 0;
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        int res = Math.max(leftDepth, rightDepth) + 1;
        return res;
    }
}
