class Solution {
    public int calculate(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        long total = 0, last = 0, num = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = a[i];
            if (c >= '0' && c <= '9') num = num * 10 + (c - '0');
            if (((c < '0' || c > '9') && c != ' ') || i == n - 1) {
                if (op == '+') { total += last; last = num; }
                else if (op == '-') { total += last; last = -num; }
                else if (op == '*') { last = last * num; }
                else { last = last / num; }
                op = c;
                num = 0;
            }
        }
        long res = total + last;
        return (int) res;
    }
}
