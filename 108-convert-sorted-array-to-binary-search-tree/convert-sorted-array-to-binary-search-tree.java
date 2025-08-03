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
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] arr, int l, int r) {
        if (l > r) return null;
        int m = (l + r) >>> 1;
        TreeNode n = new TreeNode(arr[m]);
        n.left = build(arr, l, m - 1);
        n.right = build(arr, m + 1, r);
        return n; 
    }
}