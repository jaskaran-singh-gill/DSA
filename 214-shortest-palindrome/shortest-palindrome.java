class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String rs = new StringBuilder(s).reverse().toString();
        String t = s + "#" + rs;
        int[] lps = new int[t.length()];
        for (int i = 1; i < t.length(); i++) {
            int j = lps[i - 1];
            char c = t.charAt(i);
            while (j > 0 && c != t.charAt(j)) j = lps[j - 1];
            if (c == t.charAt(j)) j++;
            lps[i] = j;
        }
        int p = lps[t.length() - 1];
        return rs.substring(0, n - p) + s;
    }
}
