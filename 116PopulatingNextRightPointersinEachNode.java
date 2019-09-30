/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node start = root;
        Node cur = null;
        Node pre = start;
        while(pre.left != null){
            if(cur != null){
                pre.left.next = pre.right;
                pre.right.next = cur.left;
                pre = pre.next;
                cur = cur.next;
            }
            else{
                pre.left.next = pre.right;
                pre.right.next = null;
                pre = start.left;
                cur = start.right;
                start = pre;
            }
        }
        return root;
    }
}

//https://leetcode.wang/leetcode-116-Populating-Next-Right-Pointers-in-Each-Node.html
