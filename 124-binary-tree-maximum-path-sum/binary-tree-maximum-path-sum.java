class Solution {
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode n) {
        if (n == null) return 0;
        int l = dfs(n.left);
        if (l < 0) l = 0;
        int r = dfs(n.right);
        if (r < 0) r = 0;
        int s = n.val + l + r;
        if (s > ans) ans = s;
        return n.val + (l > r ? l : r);
    }
}
