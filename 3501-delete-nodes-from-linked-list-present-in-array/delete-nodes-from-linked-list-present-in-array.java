class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next; 
            } else {
                prev = curr; 
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
