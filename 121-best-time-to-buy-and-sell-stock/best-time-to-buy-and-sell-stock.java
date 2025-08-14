class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = 0;
        for (int p : prices) {
            if (p < min) min = p;
            else {
                int profit = p - min;
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
