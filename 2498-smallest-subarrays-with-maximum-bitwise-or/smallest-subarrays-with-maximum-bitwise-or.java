class Solution {
    public int[] smallestSubarrays(int[] nums) 
    {
        int len = nums.length;
        int[] minLens = new int[len];
        int[] lastSeenBit = new int[32];
        
        for (int i = len - 1; i >= 0; i--) {
            for (int bit = 0; bit < 32; bit++) {
                if (((nums[i] >> bit) & 1) == 1) {
                    lastSeenBit[bit] = i;
                }
            }
            int farthest = i;
            for (int pos : lastSeenBit) {
                if (pos > farthest) farthest = pos;
            }
            minLens[i] = farthest - i + 1;
        }
        
        return minLens;
    }
}