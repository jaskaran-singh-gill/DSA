
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            List<Integer> res = new ArrayList<>(1);
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxLen = 1, maxIdx = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 1; i < n; i++) {
            int ai = nums[i];
            for (int j = 0; j < i; j++) {
                if (ai % nums[j] == 0) {
                    int cand = dp[j] + 1;
                    if (cand > dp[i]) {
                        dp[i] = cand;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>(maxLen);
        int idx = maxIdx;
        while (idx != -1) {
            res.add(nums[idx]);
            idx = prev[idx];
        }
        Collections.reverse(res);
        return res;
    }
}
