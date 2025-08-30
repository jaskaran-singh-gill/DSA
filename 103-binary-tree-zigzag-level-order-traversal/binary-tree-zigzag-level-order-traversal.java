class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean ltr = true;
        while (!q.isEmpty()) {
            int n = q.size();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                TreeNode node = q.pollFirst();
                int idx = ltr ? i : n - 1 - i;
                arr[idx] = node.val;
                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
            }
            res.add(Arrays.asList(arr));
            ltr = !ltr;
        }
        return res;
    }
}
