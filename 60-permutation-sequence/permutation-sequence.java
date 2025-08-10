class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        StringBuilder sb = new StringBuilder(n);
        int size = n;
        k--;
        for (int i = n; i >= 1; i--) {
            int idx = k / fact[i - 1];
            k %= fact[i - 1];
            sb.append(a[idx]);
            for (int j = idx; j < size - 1; j++) a[j] = a[j + 1];
            size--;
        }
        return sb.toString();
    }
}
