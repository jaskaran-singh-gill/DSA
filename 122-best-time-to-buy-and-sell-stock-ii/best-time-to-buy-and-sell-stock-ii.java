class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, res = 0;
        for (int i = 1; i < n; i++) {
            int d = prices[i] - prices[i - 1];
            if (d > 0) res += d;
        }
        return res;
    }
}
