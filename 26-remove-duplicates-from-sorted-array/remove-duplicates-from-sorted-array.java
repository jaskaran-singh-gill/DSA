class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int write = 1;
        int last = nums[0];
        for (int read = 1; read < n; read++) {
            int v = nums[read];
            if (v != last) {
                nums[write++] = v;
                last = v;
            }
        }
        return write;
    }
}

