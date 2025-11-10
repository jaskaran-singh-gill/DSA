class Solution {
    public String decodeString(String s) {
        char[] a = s.toCharArray();
        int n = a.length, sp = 0, num = 0;
        StringBuilder cur = new StringBuilder(n);
        StringBuilder[] sbStack = new StringBuilder[n];
        int[] cntStack = new int[n];
        for (int i = 0; i < n; i++) {
            char c = a[i];
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                cntStack[sp] = num;
                sbStack[sp++] = cur;
                num = 0;
                cur = new StringBuilder(Math.max(4, n));
            } else if (c == ']') {
                int k = cntStack[--sp];
                StringBuilder prev = sbStack[sp];
                prev.ensureCapacity(prev.length() + cur.length() * k);
                String t = cur.toString();
                for (int j = 0; j < k; j++) prev.append(t);
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
