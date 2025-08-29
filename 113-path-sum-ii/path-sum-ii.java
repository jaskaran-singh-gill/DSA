import java.util.*;
class Solution {
    List<List<Integer>> res;
    int[] path = new int[5000];
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0, 0, targetSum);
        return res;
    }
    void dfs(TreeNode node, int len, int sum, int target) {
        int ns = sum + node.val;
        path[len++] = node.val;
        if (node.left == null && node.right == null) {
            if (ns == target) {
                ArrayList<Integer> list = new ArrayList<>(len);
                for (int i = 0; i < len; i++) list.add(path[i]);
                res.add(list);
            }
            return;
        }
        if (node.left != null) dfs(node.left, len, ns, target);
        if (node.right != null) dfs(node.right, len, ns, target);
    }
}
