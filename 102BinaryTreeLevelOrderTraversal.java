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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); //in java queue is same as linkedlist, first in first out
        
        if(root == null) return res;
        
        queue.offer(root);
        while(!queue.isEmpty()){ //if queue is empty means we have already poll all the datas that we need
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        
        return res;
    }
}
