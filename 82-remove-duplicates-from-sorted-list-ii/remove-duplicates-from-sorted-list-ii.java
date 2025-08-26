class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int v = head.val;
                do { head = head.next; } while (head != null && head.val == v);
                prev.next = head;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
