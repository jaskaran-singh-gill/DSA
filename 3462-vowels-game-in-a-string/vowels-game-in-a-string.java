class Solution {
    public boolean doesAliceWin(String s) {
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        }
        return false;
    }
}
