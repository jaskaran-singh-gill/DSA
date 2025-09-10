class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length, top = 0;
        int[] st = new int[n];
        for (int i = 0; i < n; i++) {
            String t = tokens[i];
            int len = t.length();
            if (len == 1) {
                char c = t.charAt(0);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    int b = st[--top], a = st[--top];
                    int r;
                    switch (c) {
                        case '+': r = a + b; break;
                        case '-': r = a - b; break;
                        case '*': r = a * b; break;
                        default: r = a / b;
                    }
                    st[top++] = r;
                    continue;
                }
            }
            st[top++] = Integer.parseInt(t);
        }
        return st[0];
    }
}
