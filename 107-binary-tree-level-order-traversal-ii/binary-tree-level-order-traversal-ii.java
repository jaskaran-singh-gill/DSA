import java.util.*;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            ArrayList<Integer> level = new ArrayList<>(sz);
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                level.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.addFirst(level);
        }
        return res;
    }
}
