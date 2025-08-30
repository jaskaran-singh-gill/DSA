class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        int inIdx = 0;
        for (int i = 1; i < n; i++) {
            int v = preorder[i];
            TreeNode node = st.peek();
            if (node.val != inorder[inIdx]) {
                node.left = new TreeNode(v);
                st.push(node.left);
            } else {
                while (!st.isEmpty() && st.peek().val == inorder[inIdx]) {
                    node = st.pop();
                    inIdx++;
                }
                node.right = new TreeNode(v);
                st.push(node.right);
            }
        }
        return root;
    }
}
