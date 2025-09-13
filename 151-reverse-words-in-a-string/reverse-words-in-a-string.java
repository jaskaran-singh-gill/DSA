class Solution {
    public String reverseWords(String s) {
        int n = s.length(), i = n - 1;
        StringBuilder sb = new StringBuilder(n);
        boolean first = true;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            if (!first) sb.append(' ');
            sb.append(s, j + 1, i + 1);
            first = false;
            i = j - 1;
        }
        return sb.toString();
    }
}
