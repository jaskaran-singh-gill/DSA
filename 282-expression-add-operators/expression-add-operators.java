class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        char[] s = num.toCharArray();
        int n = s.length;
        StringBuilder sb = new StringBuilder(n * 2);
        dfs(0, 0L, 0L, s, n, sb, res, target);
        return res;
    }
    private void dfs(int i, long val, long mul, char[] s, int n, StringBuilder sb, List<String> res, long target) {
        if (i == n) {
            if (val == target) res.add(sb.toString());
            return;
        }
        long curr = 0;
        int start = sb.length();
        for (int j = i; j < n; j++) {
            if (j > i && s[i] == '0') break;
            curr = curr * 10 + (s[j] - '0');
            if (i == 0) {
                sb.append(s, i, j - i + 1);
                dfs(j + 1, curr, curr, s, n, sb, res, target);
                sb.setLength(start);
            } else {
                sb.append('+').append(s, i, j - i + 1);
                dfs(j + 1, val + curr, curr, s, n, sb, res, target);
                sb.setLength(start);
                sb.append('-').append(s, i, j - i + 1);
                dfs(j + 1, val - curr, -curr, s, n, sb, res, target);
                sb.setLength(start);
                sb.append('*').append(s, i, j - i + 1);
                dfs(j + 1, val - mul + mul * curr, mul * curr, s, n, sb, res, target);
                sb.setLength(start);
            }
        }
    }
}
