class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0, cnt = 0;
        for (int x : nums) {
            if (cnt == 0) { cand = x; cnt = 1; }
            else cnt += x == cand ? 1 : -1;
        }
        return cand;
    }
}
