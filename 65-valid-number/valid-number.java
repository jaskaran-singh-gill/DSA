class Solution {
    public boolean isNumber(String s) {
        boolean seenNum = false, seenExp = false, seenDot = false, numAfterExp = true;
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                seenNum = true;
                if (seenExp) numAfterExp = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (c == '.') {
                if (seenDot || seenExp) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenExp || !seenNum) return false;
                seenExp = true;
                numAfterExp = false;
            } else return false;
        }
        return seenNum && (!seenExp || numAfterExp);
    }
}
