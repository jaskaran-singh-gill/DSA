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
    public int minDepth(TreeNode root) {
         if (root == null) return 0;
        java.util.ArrayDeque<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; --i) {
                TreeNode n = q.poll();
                if (n.left == null && n.right == null) return depth;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            ++depth;
        }
        return depth;
    }
}