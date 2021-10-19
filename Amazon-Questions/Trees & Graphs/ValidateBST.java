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
        SOLUTION 1
            Recursion solution: O(N) time, O(N) space
    */
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);    
    }
    
    public boolean validate(TreeNode root, Integer lo, Integer hi) {
        //base case: empty trees are valid BSTs
        if (root==null) {
            return true;
        }
        
        if( (lo!=null && root.val <= lo) || (hi!=null && root.val >= hi)) {
            return false;
        }
        
        return validate(root.left, lo, root.val) && validate(root.right, root.val, hi);
    }

//============================================================================||

    /*
        SOLUTION 2
            Iterative inorder traversal: O(N) time, O(N) space
            **doesnt pass all tests because of weird double conversions...
    */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        // Integer left_child_val = - Integer.MAX_VALUE;
        Integer left_child_val = - Integer.MAX_VALUE;
        
        while (root!=null || !stack.isEmpty()) {
            //go all the way down the left children
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (root.val <= left_child_val) {
                return false;
            }
            left_child_val = root.val;
            root = root.right;
        }
        
        return true;
    }
}