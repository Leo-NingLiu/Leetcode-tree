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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, TreeNode node, int sum){
        //exit 1 this node is empty
        if(node == null) return;
        //update sum and then check sum
        int newSum = sum - node.val;
        //exit 2 this node is a leaf
        if(node.left == null && node.right == null){
            //check sum
            if(newSum == 0){
            	//backtracking
                temp.add(node.val);
                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(node.val);
        helper(res, temp, node.left, newSum); //check left tree
        helper(res, temp, node.right, newSum); //check right tree
        temp.remove(temp.size() - 1); //backtracking
    }
}
