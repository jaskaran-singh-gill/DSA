class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode aH = new ListNode(0), bH = new ListNode(0), a = aH, b = bH;
        for (ListNode cur = head; cur != null; ) {
            ListNode nxt = cur.next;
            if (cur.val < x) { a.next = cur; a = cur; }
            else { b.next = cur; b = cur; }
            cur.next = null;
            cur = nxt;
        }
        a.next = bH.next;
        return aH.next;
    }
}
