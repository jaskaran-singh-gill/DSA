class Solution {
    public int longestSubarray(int[] nums) 
    {
         int andPeak = 0;
        for (int v : nums) {
            if (v > andPeak) andPeak = v;
        }
        int spanMax = 0, spanCurr = 0;
        for (int x : nums) {
            if (x == andPeak) {
                spanCurr++;
                if (spanCurr > spanMax) spanMax = spanCurr;
            } else {
                spanCurr = 0;
            }
        }
        return spanMax;
    }
}