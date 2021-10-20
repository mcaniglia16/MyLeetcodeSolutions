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
    /*
        SOLUTION 1: recursion & backtracking
            Time O(N)
            Space O(N)
    */
   public TreeNode ancestor = null;
   
   public boolean recurseTree(TreeNode curr, TreeNode p, TreeNode q) {
       //want to find p and q in the tree
       if (curr==null) {
           return false;
       }
       
       // Left Recursion. If left recursion returns true, set left = 1 else 0
       int left = recurseTree(curr.left, p, q) ? 1 : 0;

       // Right Recursion
       int right = recurseTree(curr.right, p, q) ? 1 : 0;
       
       // If the current node is one of p or q
       int mid = (curr == p || curr == q) ? 1 : 0;
       
       if (mid + left + right >= 2) {
           ancestor = curr;
       }
       
       return (mid + left + right > 0);
   }
   
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return recurseTree(root, p, q) ? ancestor :  null;
   }
}
