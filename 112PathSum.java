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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;  
        if(root.left == null && root.right == null) return root.val == sum; //if this node is leaf, judge if its value equals to sum value.
        int temp = sum - root.val; //update sum value
        return hasPathSum(root.left, temp) || hasPathSum(root.right, temp); // use iteration
    }
}
