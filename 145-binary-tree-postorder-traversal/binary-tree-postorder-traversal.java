class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode cur = dummy;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) p = p.right;
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                } else {
                    addReverse(cur.left, p, res);
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    private void addReverse(TreeNode from, TreeNode to, List<Integer> res) {
        reverse(from, to);
        TreeNode p = to;
        while (true) {
            res.add(p.val);
            if (p == from) break;
            p = p.right;
        }
        reverse(to, from);
    }
    private void reverse(TreeNode from, TreeNode to) {
        if (from == to) return;
        TreeNode x = from, y = from.right, z;
        while (true) {
            z = y.right;
            y.right = x;
            if (y == to) break;
            x = y;
            y = z;
        }
    }
}
