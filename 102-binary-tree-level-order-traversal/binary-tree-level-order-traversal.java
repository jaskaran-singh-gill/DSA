class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> level = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                TreeNode node = q.pollFirst();
                level.add(node.val);
                TreeNode l = node.left, r = node.right;
                if (l != null) q.addLast(l);
                if (r != null) q.addLast(r);
            }
            res.add(level);
        }
        return res;
    }
}
