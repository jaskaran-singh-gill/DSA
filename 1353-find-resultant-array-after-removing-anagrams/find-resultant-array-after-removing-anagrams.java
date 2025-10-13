class Solution {
    public java.util.List<String> removeAnagrams(String[] words) {
        java.util.List<String> res = new java.util.ArrayList<>();
        int[] prev = null;
        for (int idx = 0; idx < words.length; idx++) {
            String w = words[idx];
            int[] cnt = new int[26];
            for (int i = 0, L = w.length(); i < L; i++) cnt[w.charAt(i) - 'a']++;
            boolean same = true;
            if (prev != null) {
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] != prev[i]) { same = false; break; }
                }
            } else same = false;
            if (!same) {
                res.add(w);
                prev = cnt;
            }
        }
        return res;
    }
}
