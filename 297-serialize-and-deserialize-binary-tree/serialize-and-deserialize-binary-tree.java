public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        java.util.ArrayDeque<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        sb.append(root.val).append(',');
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null) sb.append('#').append(',');
            else { sb.append(cur.left.val).append(','); q.add(cur.left); }
            if (cur.right == null) sb.append('#').append(',');
            else { sb.append(cur.right.val).append(','); q.add(cur.right); }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        char[] a = data.toCharArray();
        int n = a.length, i = 0, sign = 1, v = 0;
        if (a[i] == '-') { sign = -1; i++; }
        while (i < n && a[i] != ',') v = v * 10 + (a[i++] - '0');
        TreeNode root = new TreeNode(sign * v);
        if (i < n && a[i] == ',') i++;
        java.util.ArrayDeque<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (i < n) {
                if (a[i] == '#') { i++; if (i < n && a[i] == ',') i++; }
                else {
                    sign = 1; v = 0;
                    if (a[i] == '-') { sign = -1; i++; }
                    while (i < n && a[i] != ',') v = v * 10 + (a[i++] - '0');
                    TreeNode L = new TreeNode(sign * v);
                    cur.left = L; q.add(L);
                    if (i < n && a[i] == ',') i++;
                }
            }
            if (i < n) {
                if (a[i] == '#') { i++; if (i < n && a[i] == ',') i++; }
                else {
                    sign = 1; v = 0;
                    if (a[i] == '-') { sign = -1; i++; }
                    while (i < n && a[i] != ',') v = v * 10 + (a[i++] - '0');
                    TreeNode R = new TreeNode(sign * v);
                    cur.right = R; q.add(R);
                    if (i < n && a[i] == ',') i++;
                }
            }
        }
        return root;
    }
}
