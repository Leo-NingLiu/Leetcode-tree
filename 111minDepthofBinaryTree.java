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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;   //if root is null the min depth is 0
        return helper(root);
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE; // if the node is null means this node is an unvalid node
        }
        if(node.left == null && node.right == null){
            return 1; // if the node doesn't have children means this node is the only node, then return 1
        }
        int res = Math.min(helper(node.left), helper(node.right)) + 1;
        return res;
    }
}
