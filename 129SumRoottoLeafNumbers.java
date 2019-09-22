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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    public int helper(TreeNode node, int sum){
        if(node == null) return 0;
        sum = sum * 10 + node.val;  //calculate the actual number
        if(node.left == null && node.right == null){
            return sum; // check if it is the leaf node
        }
        return helper(node.left, sum) + helper(node.right, sum); //use iteration, we want the sum of all leaf node
    }
} 
