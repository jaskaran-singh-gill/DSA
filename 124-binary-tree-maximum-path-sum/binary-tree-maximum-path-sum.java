import java.util.*;
class Solution {
    public int maxPathSum(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        ArrayDeque<Integer> tag = new ArrayDeque<>();
        HashMap<TreeNode, Integer> gain = new HashMap<>();
        if (root == null) return 0;
        st.push(root); tag.push(0);
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            int t = tag.pop();
            if (t == 0) {
                st.push(n); tag.push(1);
                if (n.right != null) { st.push(n.right); tag.push(0); }
                if (n.left != null) { st.push(n.left); tag.push(0); }
            } else {
                int l = n.left == null ? 0 : Math.max(0, gain.get(n.left));
                int r = n.right == null ? 0 : Math.max(0, gain.get(n.right));
                int through = l + r + n.val;
                if (through > ans) ans = through;
                gain.put(n, (l >= r ? l : r) + n.val);
            }
        }
        return ans;
    }
}
