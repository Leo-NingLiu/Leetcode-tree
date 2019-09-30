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
    public void recoverTree(TreeNode root) {
        //morris traversal
        TreeNode cur = root;
        TreeNode predecessor = null;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        boolean firstTime = true;
        while(cur != null){
            if(cur.left == null){
                if(pre != null){
                    if(pre.val > cur.val && firstTime){
                        first = pre;
                        firstTime = false;
                    }
                    if(pre.val > cur.val && !firstTime){
                        second = cur;
                    }
                }
                pre = cur;
                cur = cur.right;
            }
            else{
                predecessor = cur.left;
                while(predecessor.right != null && predecessor.right != cur){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                }
                if(predecessor.right == cur){
                    predecessor.right = null;
                    if(pre != null){
                        if(pre.val > cur.val && firstTime){
                            first = pre;
                            firstTime = false;
                        }
                        if(pre.val > cur.val && !firstTime){
                            second = cur;
                        }
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        if(first != null &&  second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp; 
        }
        
    }
}
