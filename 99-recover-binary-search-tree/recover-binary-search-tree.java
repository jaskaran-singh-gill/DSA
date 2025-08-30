class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor, curr = root;
        while (curr != null) {
            if (curr.left != null) {
                predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) predecessor = predecessor.right;
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    if (pred != null && pred.val > curr.val) {
                        if (x == null) x = pred;
                        y = curr;
                    }
                    pred = curr;
                    predecessor.right = null;
                    curr = curr.right;
                }
            } else {
                if (pred != null && pred.val > curr.val) {
                    if (x == null) x = pred;
                    y = curr;
                }
                pred = curr;
                curr = curr.right;
            }
        }
        if (x != null) {
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }
}
