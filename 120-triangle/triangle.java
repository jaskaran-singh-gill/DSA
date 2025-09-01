class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int a = dp[j], b = dp[j + 1];
                dp[j] = row.get(j) + (a < b ? a : b);
            }
        }
        return dp[0];
    }
}
