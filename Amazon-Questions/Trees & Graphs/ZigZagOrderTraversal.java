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
        SOLUTION 1: 2 stacks
            Time:
            Space:
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        
        //2 stacks
        Stack<TreeNode> LR = new Stack<>(); //left to right
        Stack<TreeNode> RL = new Stack<>(); //right to left
        LR.push(root);
        List<Integer> currLevel = new ArrayList<>();
        
        while (!LR.isEmpty() || !RL.isEmpty()) {
            
            while (!LR.isEmpty()) {
                TreeNode curr = LR.pop();
                currLevel.add(curr.val);
                
                if( curr.left !=null) {
                    RL.push(curr.left);
                }
                if ( curr.right !=null) {
                    RL.push(curr.right);
                }
            }
            if (!currLevel.isEmpty()) {
                res.add(new ArrayList<>(currLevel));
            }
            currLevel.clear();
            
            while (!RL.isEmpty()) {
                TreeNode curr = RL.pop();
                currLevel.add(curr.val);
                if(curr.right!=null) {
                    LR.push(curr.right);
                }
                if (curr.right!=null) {
                    LR.push(curr.left);
                }
            }
            if (!currLevel.isEmpty()) {
                res.add(new ArrayList<>(currLevel));
            }
            currLevel.clear();
        }
        return res;
    }

    /////////////////////////////////////////////////////////////
    /*
        Optimal Solution: BFS
    */
}