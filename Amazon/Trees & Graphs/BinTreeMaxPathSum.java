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
    int max_path_sum;
    public int maxPathSum(TreeNode root) {
        max_path_sum = Integer.MIN_VALUE;
        pathSum(root);
        return max_path_sum;
    }
    
    public int pathSum(TreeNode root) {
        if (root==null)
            return 0;
        
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        max_path_sum = Math.max(max_path_sum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}