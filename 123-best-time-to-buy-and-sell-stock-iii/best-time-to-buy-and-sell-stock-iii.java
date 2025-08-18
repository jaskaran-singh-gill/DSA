class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE >> 1, sell1 = 0, buy2 = Integer.MIN_VALUE >> 1, sell2 = 0;
        for (int i = 0, n = prices.length; i < n; i++) {
            int p = prices[i];
            if (-p > buy1) buy1 = -p;
            int t1 = buy1 + p;
            if (t1 > sell1) sell1 = t1;
            int t2 = sell1 - p;
            if (t2 > buy2) buy2 = t2;
            int t3 = buy2 + p;
            if (t3 > sell2) sell2 = t3;
        }
        return sell2;
    }
}
