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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tailTracker = dummyHead;
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            tailTracker.next = smallestNode;
            tailTracker = tailTracker.next;
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }
        return dummyHead.next;
    }
}