class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int c = 0;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (++c == k) return cur.val;
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) p = p.right;
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                } else {
                    p.right = null;
                    if (++c == k) return cur.val;
                    cur = cur.right;
                }
            }
        }
        return -1;
    }
}
