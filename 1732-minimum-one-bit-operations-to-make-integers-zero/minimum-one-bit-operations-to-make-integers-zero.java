class Solution {
    public int minimumOneBitOperations(int n) {
        int r = 0;
        while (n != 0) {
            r ^= n;
            n >>= 1;
        }
        return r;
    }
}

