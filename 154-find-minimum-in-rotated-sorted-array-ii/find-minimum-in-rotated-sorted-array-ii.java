class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];
        while (l < r) {
            int m = (l + r) >>> 1;
            int mv = nums[m], rv = nums[r];
            if (mv < rv) r = m;
            else if (mv > rv) l = m + 1;
            else r--;
        }
        return nums[l];
    }
}
