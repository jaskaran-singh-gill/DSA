class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) p = p.right;
                if (p.right == null) {
                    res.add(cur.val);
                    p.right = cur;
                    cur = cur.left;
                } else {
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
