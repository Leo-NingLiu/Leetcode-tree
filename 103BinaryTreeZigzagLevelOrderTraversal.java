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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.offer(root);
        int flag = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                if(flag % 2 == 0){
                    temp.add(node.val);
                }
                else{
                    stack.push(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            while(!stack.isEmpty()){
                temp.add(stack.pop());
            }
            flag++;
            res.add(temp);
        }
        return res;
        
    }
    
}
