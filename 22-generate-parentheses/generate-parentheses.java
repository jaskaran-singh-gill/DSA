class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> res = new ArrayList<>(1 << n);
        char[] path = new char[n * 2];
        build(res, path, 0, 0, n);
        return res;
    }

    private void build(List<String> res, char[] path, int open, int close, int max) {
        if (open + close == max * 2) {
            res.add(new String(path));
            return;
        }
        if (open < max) {
            path[open + close] = '(';
            build(res, path, open + 1, close, max);
        }
        if (close < open) {
            path[open + close] = ')';
            build(res, path, open, close + 1, max);
        }
    }
}