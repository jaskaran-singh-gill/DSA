/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists)
     {
         if (lists == null || lists.length == 0) return null;
        int n = lists.length;
        while (n > 1) {
            int mid = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists[i] = merge(lists[i], lists[i + mid]);
            }
            n = mid;
        }
        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }
}