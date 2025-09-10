class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) n++;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy, cur = dummy.next;
            while (cur != null) {
                ListNode h1 = cur;
                int i = 1;
                while (i < step && cur.next != null) { cur = cur.next; i++; }
                ListNode h2 = cur.next;
                cur.next = null;
                cur = h2;
                i = 1;
                while (i < step && cur != null && cur.next != null) { cur = cur.next; i++; }
                ListNode next = null;
                if (cur != null) { next = cur.next; cur.next = null; }
                prev = merge(h1, h2, prev);
                cur = next;
            }
        }
        return dummy.next;
    }
    private ListNode merge(ListNode a, ListNode b, ListNode prev) {
        ListNode p = prev;
        while (a != null && b != null) {
            if (a.val <= b.val) { p.next = a; a = a.next; }
            else { p.next = b; b = b.next; }
            p = p.next;
        }
        while (a != null) { p.next = a; a = a.next; p = p.next; }
        while (b != null) { p.next = b; b = b.next; p = p.next; }
        return p;
    }
}
