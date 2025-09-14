import java.util.*;

class Solution {
    private static String devowel(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') c[i] = '#';
            else c[i] = ch;
        }
        return new String(c);
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exact = new HashSet<>(wordlist.length<<1);
        HashMap<String,String> lower = new HashMap<>(wordlist.length<<1);
        HashMap<String,String> deV = new HashMap<>(wordlist.length<<1);
        for (String w : wordlist) {
            exact.add(w);
            String lw = w.toLowerCase();
            lower.putIfAbsent(lw, w);
            deV.putIfAbsent(devowel(w), w);
        }
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) { ans[i] = q; continue; }
            String lq = q.toLowerCase();
            String r = lower.get(lq);
            if (r != null) { ans[i] = r; continue; }
            r = deV.get(devowel(q));
            ans[i] = r == null ? "" : r;
        }
        return ans;
    }
}
