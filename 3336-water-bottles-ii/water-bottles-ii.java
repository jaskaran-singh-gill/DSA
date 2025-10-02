class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles, empty = 0, ex = numExchange, ans = 0;
        while (true) {
            if (full > 0) {
                ans += full;
                empty += full;
                full = 0;
            }
            if (empty < ex) break;
            empty -= ex;
            ex++;
            full++;
        }
        return ans;
    }
}
