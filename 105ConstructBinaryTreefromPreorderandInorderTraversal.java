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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int pre_start, int inorder_start, int inorder_end){
        //exit
        if(pre_start >= preorder.length || inorder_start > inorder_end) return null;
        int val = preorder[pre_start];
        int index = 0;
        for(int i = 0; i < preorder.length; i++){
            if(inorder[i] == val){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int leftsize = index - inorder_start + 1;
        root.left = helper(preorder, inorder, pre_start + 1, inorder_start, index - 1);
        root.right = helper(preorder, inorder, pre_start + leftsize, index + 1, inorder_end);
        return root;
    }
}
