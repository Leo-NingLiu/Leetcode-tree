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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode node){
        if(node == null) return null;
        TreeNode leftNode = helper(node.left);
        TreeNode rightNode = helper(node.right);
        //3 steps
        if(leftNode != null){
            //右边的接到左边
            leftNode.right = node.right;
            //左边的接到右边
            node.right = node.left;
            //左边赋值为空
            node.left = null;
        }
        if(rightNode != null) return rightNode;
        if(leftNode != null) return leftNode;
        return node;
    }
}
