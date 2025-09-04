class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, start = 0, tank = 0, total = 0;
        for (int i = 0; i < n; i++) {
            int d = gas[i] - cost[i];
            tank += d;
            total += d;
            if (tank < 0) { start = i + 1; tank = 0; }
        }
        return total >= 0 ? start : -1;
    }
}
