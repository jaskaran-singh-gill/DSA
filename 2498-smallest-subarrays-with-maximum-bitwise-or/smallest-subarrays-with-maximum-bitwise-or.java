class Solution {
    public int[] smallestSubarrays(int[] nums) 
    {
      int n = nums.length;
        int[] suffixOR = new int[n];
        suffixOR[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixOR[i] = nums[i] | suffixOR[i + 1];
        }
        
        int[] nextSet = new int[32];
        java.util.Arrays.fill(nextSet, -1);
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int current = nums[i];
            for (int k = 0; k < 32; k++) {
                if ((current >> k & 1) == 1) {
                    nextSet[k] = i;
                }
            }
            
            int maxJ = i;
            int target = suffixOR[i];
            for (int k = 0; k < 32; k++) {
                if ((target >> k & 1) == 1) {
                    if (nextSet[k] != -1 && nextSet[k] > maxJ) {
                        maxJ = nextSet[k];
                    }
                }
            }
            ans[i] = maxJ - i + 1;
        }
        
        return ans;
    }
}