import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int n = nums.length, i = 0;
        while (i < n) {
            int a = nums[i], j = i;
            while (j + 1 < n && (long)nums[j + 1] - nums[j] == 1L) j++;
            if (j == i) res.add(Integer.toString(a));
            else res.add(a + "->" + nums[j]);
            i = j + 1;
        }
        return res;
    }
}
