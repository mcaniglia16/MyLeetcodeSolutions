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
    
    // Solution 1: Recursive
    // O(N) time
    // O(N) space => The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n).
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    
    public boolean check(TreeNode t1, TreeNode t2) {
        if (t1==null && t2==null) return true;
        if (t1==null || t2==null) return false;
        
        return (t1.val==t2.val) 
            && check(t1.right, t2.left)
            && check(t1.left, t2.right);
    }
    
    //////////////////////////////////////////////////
    /*
        SOLUTION 2: iterative using Queue
        Time complexity: O(n). Because we traverse the entire input tree once, the total run time is O(n), where n is the total number of nodes in the tree.

        Space complexity: There is additional space required for the search queue. In the worst case, we have to insert O(n) nodes in the queue. Therefore, space complexity is O(n).
    */
    public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
}