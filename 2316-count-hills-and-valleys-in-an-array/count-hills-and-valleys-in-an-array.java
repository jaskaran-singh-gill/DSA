class Solution {
    public int countHillValley(int[] nums) 
    {
        int n = nums.length;
        if (n < 3) return 0;
        int countHV = 0;
        int prevSegmentVal = nums[0];
        int idx = 1;
        while (idx < n - 1) {
            int currentVal = nums[idx];
            int nextIdx = idx;
            while (nextIdx < n && nums[nextIdx] == currentVal) {
                nextIdx++;
            }
            if (nextIdx >= n) break;
            int nextVal = nums[nextIdx];
            if ((currentVal > prevSegmentVal && currentVal > nextVal) || 
                (currentVal < prevSegmentVal && currentVal < nextVal)) {
                countHV++;
            }
            prevSegmentVal = currentVal;
            idx = nextIdx;
        }
        return countHV;
    }
}