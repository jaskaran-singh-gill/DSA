import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> ns = new ArrayDeque<>();
        ArrayDeque<String> ps = new ArrayDeque<>();
        ns.add(root);
        ps.add(Integer.toString(root.val));
        while (!ns.isEmpty()) {
            TreeNode cur = ns.pollLast();
            String path = ps.pollLast();
            TreeNode l = cur.left, r = cur.right;
            if (l == null && r == null) {
                res.add(path);
            } else {
                if (r != null) {
                    ns.add(r);
                    ps.add(path + "->" + r.val);
                }
                if (l != null) {
                    ns.add(l);
                    ps.add(path + "->" + l.val);
                }
            }
        }
        return res;
    }
}
