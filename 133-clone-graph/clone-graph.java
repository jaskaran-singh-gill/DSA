/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node[] clones = new Node[101];
        boolean[] seen = new boolean[101];
        java.util.ArrayDeque<Node> q = new java.util.ArrayDeque<>();
        clones[node.val] = new Node(node.val);
        q.add(node);
        seen[node.val] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            Node cc = clones[cur.val];
            for (Node nb : cur.neighbors) {
                if (clones[nb.val] == null) clones[nb.val] = new Node(nb.val);
                cc.neighbors.add(clones[nb.val]);
                if (!seen[nb.val]) {
                    seen[nb.val] = true;
                    q.add(nb);
                }
            }
        }
        return clones[node.val];
    }
}
