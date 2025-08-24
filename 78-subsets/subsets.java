import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, total = 1 << n;
        List<List<Integer>> res = new ArrayList<>(total);
        for (int mask = 0; mask < total; mask++) {
            ArrayList<Integer> cur = new ArrayList<>(Integer.bitCount(mask));
            for (int i = 0; i < n; i++) if ((mask & (1 << i)) != 0) cur.add(nums[i]);
            res.add(cur);
        }
        return res;
    }
}
