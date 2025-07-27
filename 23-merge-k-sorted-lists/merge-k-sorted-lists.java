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
        int totalLists = lists.length;
        while (totalLists > 1) {
            int mergedIndex = 0;
            for (int i = 0; i < totalLists; i += 2) {
                if (i + 1 < totalLists) {
                    lists[mergedIndex] = mergeTwoLists(lists[i], lists[i + 1]);
                } else {
                    lists[mergedIndex] = lists[i];
                }
                mergedIndex++;
            }
            totalLists = mergedIndex;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;
        return dummyHead.next;
    }
}