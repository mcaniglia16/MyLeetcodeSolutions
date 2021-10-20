/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        SOLUTION 1: DFS
            O(N) time
            O(N) space
    */
    
    //the longest path has to be between two leaf nodes.
    //longest path in the tree would consist of a node, its longest left branch, and its longest right branch
    //our algorithm to solve this problem will find the node where the sum of its longest left and right branches is maximized
        
    public int maxPath;
    
    public int longestPath(TreeNode root) {
        if (root==null) {
            return 0; //height = 0 -> leaf node of the tree
        }
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);
            
        maxPath = Math.max(maxPath, leftPath + rightPath);
            
        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxPath = 0;
        longestPath(root);
        return maxPath;
    }    
}