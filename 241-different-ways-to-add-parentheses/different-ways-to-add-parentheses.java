
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        int[] nums = new int[n + 1];
        char[] ops = new char[n];
        int ni = 0, oi = 0, i = 0;
        while (i < n) {
            int v = 0;
            while (i < n) {
                char c = expression.charAt(i);
                if (c >= '0' && c <= '9') { v = v * 10 + (c - '0'); i++; }
                else break;
            }
            nums[ni++] = v;
            if (i < n) ops[oi++] = expression.charAt(i++);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[][] memo = new ArrayList[ni][ni];
        return solve(0, ni - 1, nums, ops, memo);
    }

    private ArrayList<Integer> solve(int l, int r, int[] nums, char[] ops, ArrayList<Integer>[][] memo) {
        ArrayList<Integer> res = memo[l][r];
        if (res != null) return res;
        if (l == r) {
            res = new ArrayList<>(1);
            res.add(nums[l]);
            memo[l][r] = res;
            return res;
        }
        res = new ArrayList<>();
        for (int k = l; k < r; k++) {
            ArrayList<Integer> A = solve(l, k, nums, ops, memo);
            ArrayList<Integer> B = solve(k + 1, r, nums, ops, memo);
            char op = ops[k];
            for (int i = 0, asz = A.size(); i < asz; i++) {
                int a = A.get(i);
                for (int j = 0, bsz = B.size(); j < bsz; j++) {
                    int b = B.get(j);
                    int v;
                    if (op == '+') v = a + b;
                    else if (op == '-') v = a - b;
                    else v = a * b;
                    res.add(v);
                }
            }
        }
        memo[l][r] = res;
        return res;
    }
}
