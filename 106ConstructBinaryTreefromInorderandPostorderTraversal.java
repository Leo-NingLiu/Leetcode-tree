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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int post_end, int inorder_start, int inorder_end){
        //exit
        if(post_end < 0 || inorder_start > inorder_end) return null;
        int val = postorder[post_end];
        int index = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == val){
                index = i;
                break;
            }
        }
        int rightsize = inorder_end - index + 1;
        TreeNode root = new TreeNode(val);
        root.left = helper(inorder, postorder, post_end - rightsize, inorder_start, index - 1);
        root.right = helper(inorder, postorder, post_end - 1, index + 1, inorder_end);
        return root;
    }
}
