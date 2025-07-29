class Solution {
    public int removeElement(int[] nums, int val) {
         int end = nums.length;
        int i = 0;
        while (i < end) {
            if (nums[i] == val) {
                nums[i] = nums[--end];
            } else {
                i++;
            }
        }
        return end;
    }
}