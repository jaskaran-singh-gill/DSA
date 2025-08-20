class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[] prev = new int[n + 1], curr = new int[n + 1];
        for (int j = 0; j <= n; j++) prev[j] = j;
        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (c1 == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int insert = curr[j - 1];
                    int delete = prev[j];
                    int replace = prev[j - 1];
                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            int[] tmp = prev; prev = curr; curr = tmp;
        }
        return prev[n];
    }
}
