class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) return "";
        int[] need = new int[128];
        for (int i = 0; i < n; i++) need[t.charAt(i)]++;
        int required = n, left = 0, start = 0, best = Integer.MAX_VALUE;
        for (int right = 0; right < m; right++) {
            char c = s.charAt(right);
            if (need[c] > 0) required--;
            need[c]--;
            while (required == 0) {
                int len = right - left + 1;
                if (len < best) { best = len; start = left; }
                char d = s.charAt(left++);
                need[d]++;
                if (need[d] > 0) required++;
            }
        }
        return best == Integer.MAX_VALUE ? "" : s.substring(start, start + best);
    }
}
