class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, target = n - k, l = 0, r = n - 1;
        while (l <= r) {
            int pivot = nums[(l + r) >>> 1];
            int i = l, lt = l, gt = r;
            while (i <= gt) {
                int v = nums[i];
                if (v < pivot) { int t = nums[lt]; nums[lt++] = v; nums[i++] = t; }
                else if (v > pivot) { int t = nums[gt]; nums[gt--] = v; nums[i] = t; }
                else i++;
            }
            if (target < lt) r = lt - 1;
            else if (target > gt) l = gt + 1;
            else return nums[target];
        }
        return -1;
    }
}
