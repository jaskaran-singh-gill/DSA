import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, d = 0;
        int[] val = new int[n], cnt = new int[n];
        for (int i = 0; i < n;) {
            int v = nums[i], j = i + 1;
            while (j < n && nums[j] == v) j++;
            val[d] = v;
            cnt[d] = j - i;
            d++;
            i = j;
        }
        int total = 1;
        for (int i = 0; i < d; i++) total *= cnt[i] + 1;
        List<List<Integer>> res = new ArrayList<>(total);
        res.add(new ArrayList<>());
        for (int i = 0; i < d; i++) {
            int s = res.size();
            for (int j = 0; j < s; j++) {
                List<Integer> base = res.get(j);
                ArrayList<Integer> cur = new ArrayList<>(base.size() + cnt[i]);
                cur.addAll(base);
                for (int k = 1; k <= cnt[i]; k++) {
                    cur.add(val[i]);
                    res.add(new ArrayList<>(cur));
                }
            }
        }
        return res;
        }
}
