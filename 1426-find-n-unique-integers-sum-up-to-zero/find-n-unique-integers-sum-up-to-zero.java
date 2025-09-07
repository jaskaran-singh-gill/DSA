class Solution {
    public int[] sumZero(int n) {
        int[] a = new int[n];
        int i = 0, v = 1, k = n >> 1;
        while (k-- > 0) { a[i++] = v; a[i++] = -v; v++; }
        if ((n & 1) == 1) a[i] = 0;
        return a;
    }
}
