class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1, v = nums[m];
            if (v == target) return true;
            int lv = nums[l], rv = nums[r];
            if (lv == v && v == rv) { l++; r--; continue; }
            if (lv <= v) {
                if (lv <= target && target < v) r = m - 1;
                else l = m + 1;
            } else {
                if (v < target && target <= rv) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}

