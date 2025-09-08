class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode last = head, cur = head.next;
        while (cur != null) {
            if (last.val <= cur.val) {
                last = cur;
                cur = cur.next;
            } else {
                int v = cur.val;
                ListNode p = dummy;
                while (p.next.val <= v) p = p.next;
                last.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = last.next;
            }
        }
        return dummy.next;
    }
}
