class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) return numBottles;
        return numBottles + (numBottles - numExchange) / (numExchange - 1) + 1;
    }
}
