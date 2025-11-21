class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }
        char[] a = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int c = a[i] - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        int ans = 0;
        boolean[] seen = new boolean[26];
        for (int c = 0; c < 26; c++) {
            int l = first[c], r = last[c];
            if (l != -1 && r - l >= 2) {
                for (int i = 0; i < 26; i++) seen[i] = false;
                int cnt = 0;
                for (int i = l + 1; i < r; i++) {
                    int x = a[i] - 'a';
                    if (!seen[x]) {
                        seen[x] = true;
                        cnt++;
                    }
                }
                ans += cnt;
            }
        }
        return ans;
    }
}
