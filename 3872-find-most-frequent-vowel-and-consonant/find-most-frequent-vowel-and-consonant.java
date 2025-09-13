class Solution {
    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        boolean[] v = new boolean[26];
        v['a'-97]=v['e'-97]=v['i'-97]=v['o'-97]=v['u'-97]=true;
        int mv = 0, mc = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 97;
            int c = ++cnt[idx];
            if (v[idx]) { if (c > mv) mv = c; }
            else { if (c > mc) mc = c; }
        }
        return mv + mc;
    }
}
