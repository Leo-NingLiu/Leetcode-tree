/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//inorder means we need to check the left tree first and then check the root finally check the right tree
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res){
        if(root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}
