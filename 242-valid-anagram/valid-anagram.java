class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (t.length() != n) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for (int v : cnt) if (v != 0) return false;
        return true;
    }
}
