class Solution {
    public int firstMissingPositive(int[] nums) 
    {
    int n = nums.length;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (v >= 1 && v <= n && nums[v - 1] != v) {
                int tmp = nums[v - 1];
                nums[v - 1] = v;
                v = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;    
    }
}