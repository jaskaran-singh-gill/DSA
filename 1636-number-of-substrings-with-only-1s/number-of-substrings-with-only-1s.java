class Solution {
    public int numSub(String s) {
        long ans = 0, cur = 0;
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cur++;
                ans += cur;
                if (ans >= mod) ans %= mod;
            } else {
                cur = 0;
            }
        }
        return (int)(ans % mod);
    }
}
