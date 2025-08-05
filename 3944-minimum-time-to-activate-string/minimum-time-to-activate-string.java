class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        long total = (long) n * (n + 1) / 2;
        if (k > total) return -1;
        long limit = total - k;
        java.util.TreeSet<Integer> set = new java.util.TreeSet<>();
        set.add(-1);
        set.add(n);
        long cur = total;
        for (int t = 0; t < n; t++) {
            int p = order[t];
            int l = set.floor(p);
            int r = set.ceiling(p);
            long len = r - l - 1L;
            cur -= len * (len + 1) / 2;
            long left = p - l - 1L;
            long right = r - p - 1L;
            cur += left * (left + 1) / 2 + right * (right + 1) / 2;
            set.add(p);
            if (cur <= limit) return t;
        }
        return -1;
    }
}
