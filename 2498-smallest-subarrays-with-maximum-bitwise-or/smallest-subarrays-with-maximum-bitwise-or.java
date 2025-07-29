class Solution {
    public int[] smallestSubarrays(int[] nums) 
    {
       int n = nums.length;
        int[] out = new int[n];
        int[] recent = new int[32];
        int bitCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            for (int b = 0; b < 32; b++) {
                if ((val & (1 << b)) != 0) recent[b] = i;
            }
            int max = i;
            for (int b = 0; b < 32; b++) {
                if (recent[b] > max) max = recent[b];
            }
            out[i] = max - i + 1;
        }

        return out;
    }
}