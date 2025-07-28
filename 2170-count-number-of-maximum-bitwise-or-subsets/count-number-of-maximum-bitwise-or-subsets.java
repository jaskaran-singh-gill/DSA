class Solution {
    public int countMaxOrSubsets(int[] nums) 
    {
      int n = nums.length;
        int maxOr = 0, count = 0;

        for (int num : nums) maxOr |= num;

        int total = 1 << n;
        for (int mask = 1; mask < total; mask++) {
            int orVal = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) orVal |= nums[i];
            }
            if (orVal == maxOr) count++;
        }
        return count;   
    }
}