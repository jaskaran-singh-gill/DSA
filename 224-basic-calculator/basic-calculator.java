class Solution {
    public int calculate(String s) {
        char[] a = s.toCharArray();
        int n = a.length, res = 0, num = 0, sign = 1, sp = 0;
        int[] st = new int[n];
        for (int i = 0; i < n; i++) {
            char c = a[i];
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                st[sp++] = res;
                st[sp++] = sign;
                res = 0;
                sign = 1;
            } else {
                res += sign * num;
                num = 0;
                int ps = st[--sp];
                int pr = st[--sp];
                res = pr + ps * res;
            }
        }
        res += sign * num;
        return res;
    }
}
