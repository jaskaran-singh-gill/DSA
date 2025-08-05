class Solution {
    public long maxSumTrionic(int[] nums) {
        long NEG = Long.MIN_VALUE / 4;
        long inc = NEG, dec = NEG, inc2 = NEG, best = NEG;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                long pair = (long) nums[i - 1] + nums[i];
                long nInc = inc != NEG ? Math.max(pair, inc + nums[i]) : pair;
                long nInc2 = NEG;
                if (dec != NEG) nInc2 = dec + nums[i];
                if (inc2 != NEG && inc2 + nums[i] > nInc2) nInc2 = inc2 + nums[i];
                inc = nInc;
                dec = NEG;
                inc2 = nInc2;
            } else if (nums[i] < nums[i - 1]) {
                long nDec = NEG;
                if (dec != NEG) nDec = dec + nums[i];
                if (inc != NEG && inc + nums[i] > nDec) nDec = inc + nums[i];
                inc = NEG;
                dec = nDec;
                inc2 = NEG;
            } else {
                inc = dec = inc2 = NEG;
            }
            if (inc2 != NEG && inc2 > best) best = inc2;
        }
        return best;
    }
}
