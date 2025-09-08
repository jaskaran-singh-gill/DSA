import java.util.ArrayDeque;

class BSTIterator {
    ArrayDeque<TreeNode> st = new ArrayDeque<>();
    public BSTIterator(TreeNode root) { push(root); }
    private void push(TreeNode x){ while(x!=null){ st.push(x); x=x.left; } }
    public int next() {
        TreeNode x = st.pop();
        if (x.right != null) push(x.right);
        return x.val;
    }
    public boolean hasNext() { return !st.isEmpty(); }
}
