class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node c = new Node(cur.val);
            c.next = cur.next;
            cur.next = c;
            cur = c.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        Node dummy = new Node(0), t = dummy;
        cur = head;
        while (cur != null) {
            Node c = cur.next;
            cur.next = c.next;
            t.next = c;
            t = c;
            cur = cur.next;
        }
        return dummy.next;
    }
}
