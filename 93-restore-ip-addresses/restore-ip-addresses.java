import java.util.*;
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4 || n > 12) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int[] st = new int[4], ln = new int[4];
        dfs(s, n, 0, 0, st, ln, res);
        return res;
    }
    void dfs(String s, int n, int idx, int part, int[] st, int[] ln, List<String> res) {
        if (part == 4) {
            if (idx == n) {
                StringBuilder sb = new StringBuilder(n + 3);
                for (int i = 0; i < 4; i++) {
                    if (i > 0) sb.append('.');
                    sb.append(s, st[i], st[i] + ln[i]);
                }
                res.add(sb.toString());
            }
            return;
        }
        int rem = n - idx, segs = 4 - part;
        if (rem < segs || rem > segs * 3) return;
        char c0 = s.charAt(idx);
        int v = c0 - '0';
        st[part] = idx;
        ln[part] = 1;
        int remAfter = n - (idx + 1), leftSegs = 3 - part;
        if (remAfter >= leftSegs && remAfter <= leftSegs * 3) dfs(s, n, idx + 1, part + 1, st, ln, res);
        if (c0 == '0') return;
        if (idx + 1 < n) {
            v = v * 10 + (s.charAt(idx + 1) - '0');
            if (v <= 255) {
                ln[part] = 2;
                remAfter = n - (idx + 2);
                if (remAfter >= leftSegs && remAfter <= leftSegs * 3) dfs(s, n, idx + 2, part + 1, st, ln, res);
            }
        }
        if (idx + 2 < n) {
            v = v * 10 + (s.charAt(idx + 2) - '0');
            if (v <= 255) {
                ln[part] = 3;
                remAfter = n - (idx + 3);
                if (remAfter >= leftSegs && remAfter <= leftSegs * 3) dfs(s, n, idx + 3, part + 1, st, ln, res);
            }
        }
    }
}
