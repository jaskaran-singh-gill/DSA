class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node level = root;
        while (level.left != null) {
            Node cur = level;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }
}
