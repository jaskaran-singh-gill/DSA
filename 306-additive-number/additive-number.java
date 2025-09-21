class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int len1 = 1; len1 <= n - 2; len1++) {
            if (num.charAt(0) == '0' && len1 > 1) break;
            for (int len2 = 1; len2 <= n - len1 - 1; len2++) {
                if (num.charAt(len1) == '0' && len2 > 1) break;
                if (n - (len1 + len2) < Math.max(len1, len2)) break;
                if (check(num, 0, len1, len1, len2)) return true;
            }
        }
        return false;
    }

    private boolean check(String s, int aStart, int aLen, int bStart, int bLen) {
        int n = s.length();
        int k = bStart + bLen;
        while (k < n) {
            String sum = add(s, aStart, aLen, bStart, bLen);
            int sl = sum.length();
            if (k + sl > n) return false;
            for (int i = 0; i < sl; i++) if (s.charAt(k + i) != sum.charAt(i)) return false;
            aStart = bStart; aLen = bLen;
            bStart = k; bLen = sl;
            k += sl;
        }
        return true;
    }

    private String add(String s, int aStart, int aLen, int bStart, int bLen) {
        StringBuilder sb = new StringBuilder(Math.max(aLen, bLen) + 1);
        int i = aStart + aLen - 1, j = bStart + bLen - 1, carry = 0;
        while (i >= aStart || j >= bStart || carry != 0) {
            int x = i >= aStart ? s.charAt(i--) - '0' : 0;
            int y = j >= bStart ? s.charAt(j--) - '0' : 0;
            int z = x + y + carry;
            sb.append((char)('0' + (z % 10)));
            carry = z / 10;
        }
        return sb.reverse().toString();
    }
}
