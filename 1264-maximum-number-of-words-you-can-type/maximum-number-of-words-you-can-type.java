class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int mask = 0;
        for (int i = 0; i < brokenLetters.length(); i++) mask |= 1 << (brokenLetters.charAt(i) - 'a');
        int ans = 0;
        boolean ok = true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') { if (ok) ans++; ok = true; }
            else if ((mask & (1 << (c - 'a'))) != 0) ok = false;
        }
        if (ok) ans++;
        return ans;
    }
}
