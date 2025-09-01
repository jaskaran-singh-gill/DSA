class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        java.util.HashSet<Integer> set = new java.util.HashSet<>((int)(n / 0.75f) + 1);
        for (int v : nums) set.add(v);
        int best = 0;
        for (int v : set) {
            if (!set.contains(v - 1)) {
                int cur = v, len = 1;
                while (true) {
                    int next = cur + 1;
                    if (next < cur || !set.contains(next)) break;
                    cur = next;
                    len++;
                }
                if (len > best) best = len;
            }
        }
        return best;
    }
}
