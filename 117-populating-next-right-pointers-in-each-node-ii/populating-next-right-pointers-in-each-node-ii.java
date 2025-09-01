class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0), tail = dummy;
            for (Node p = cur; p != null; p = p.next) {
                if (p.left != null) { tail.next = p.left; tail = tail.next; }
                if (p.right != null) { tail.next = p.right; tail = tail.next; }
            }
            cur = dummy.next;
        }
        return root;
    }
}
