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
        while(root != null){
            //检查左子树是否为空，若为空扫描下一层
            if(root.left == null){
                root = root.right;
            }
            else{
                TreeNode cur = root.left;
                while(cur.right != null){
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}

//https://leetcode.wang/leetcode-114-Flatten-Binary-Tree-to-Linked-List.html 解法1
