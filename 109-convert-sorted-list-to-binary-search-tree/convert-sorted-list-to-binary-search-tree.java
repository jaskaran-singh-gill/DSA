class Solution {
    ListNode p;
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        for (ListNode t = head; t != null; t = t.next) n++;
        p = head;
        return build(0, n - 1);
    }
    private TreeNode build(int l, int r) {
        if (l > r) return null;
        int m = (l + r) >>> 1;
        TreeNode left = build(l, m - 1);
        TreeNode root = new TreeNode(p.val);
        p = p.next;
        root.left = left;
        root.right = build(m + 1, r);
        return root;
    }
}
