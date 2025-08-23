import java.util.*;
class Solution {
    List<TreeNode>[][] dp;
    final List<TreeNode> empty = Collections.singletonList(null);
    public List<TreeNode> generateTrees(int n) {
        dp = new List[n + 2][n + 2];
        return gen(1, n);
    }
    List<TreeNode> gen(int l, int r) {
        if (l > r) return empty;
        List<TreeNode> res = dp[l][r];
        if (res != null) return res;
        res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<TreeNode> L = gen(l, i - 1), R = gen(i + 1, r);
            for (int a = 0, ls = L.size(); a < ls; a++) {
                TreeNode left = L.get(a);
                for (int b = 0, rs = R.size(); b < rs; b++) {
                    TreeNode right = R.get(b);
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        dp[l][r] = res;
        return res;
    }
}
