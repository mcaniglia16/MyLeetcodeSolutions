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
            Left -> Node -> Right order of INORDER traversal means for BST that each element should be smaller than the next one.
            **doesnt pass all tests because of weird double conversions...
    */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        // Integer left_child_val = - Integer.MAX_VALUE;
        Integer previous = - Integer.MAX_VALUE;
        
        while (root!=null || !stack.isEmpty()) {
            //go all the way down the left children
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (root.val <= previous) {
                return false;
            }
            previous = root.val;
            root = root.right;
        }
        
        return true;
    }

    //============================================================================||

    /*
        SOLUTION 3
            recursive inorder traversal: O(N) time, O(N) space

            Time complexity : O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.
            Space complexity : O(N) for the space on the run-time stack.
    */
    // We use Integer instead of int as it supports a null value.
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}