class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length(), max = 0;
        HashSet<String> set = new HashSet<>(wordDict);
        for (String w : wordDict) if (w.length() > max) max = w.length();
        boolean[] can = new boolean[n + 1];
        can[0] = true;
        for (int i = 0; i < n; i++) {
            if (!can[i]) continue;
            int end = Math.min(n, i + max);
            for (int j = i + 1; j <= end; j++) if (set.contains(s.substring(i, j))) can[j] = true;
        }
        if (!can[n]) return new ArrayList<>();
        return dfs(0, s, set, max, can, new HashMap<>());
    }
    private List<String> dfs(int i, String s, HashSet<String> set, int max, boolean[] can, HashMap<Integer, List<String>> memo) {
        if (i == s.length()) return Collections.singletonList("");
        List<String> res = memo.get(i);
        if (res != null) return res;
        res = new ArrayList<>();
        int n = s.length(), end = Math.min(n, i + max);
        for (int j = i + 1; j <= end; j++) {
            if (!can[j]) continue;
            String w = s.substring(i, j);
            if (!set.contains(w)) continue;
            List<String> tails = dfs(j, s, set, max, can, memo);
            for (int k = 0, m = tails.size(); k < m; k++) {
                String t = tails.get(k);
                res.add(t.isEmpty() ? w : w + " " + t);
            }
        }
        memo.put(i, res);
        return res;
    }
}
