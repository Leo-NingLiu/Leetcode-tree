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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0) return res;
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        if(start == end){
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftList = helper(start, i - 1);
            List<TreeNode> rightList = helper(i + 1, end);
            for(TreeNode right : rightList){
                for(TreeNode left : leftList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
