
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long last = Long.MIN_VALUE;
        int count = 0;
        for (int x : nums) {
            long low = (long)x - k, high = (long)x + k;
            long val = Math.max(low, last + 1);
            if (val <= high) {
                count++;
                last = val;
            }
        }
        return count;
    }
}
