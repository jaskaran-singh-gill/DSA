class Solution {
    public int findNthDigit(int n) {
        long nLong = n;
        long len = 1, count = 9;
        while (nLong > len * count) {
            nLong -= len * count;
            len++;
            count *= 10;
        }
        long[] pow = new long[20];
        pow[0] = 1;
        for (int i = 1; i < 20; i++) pow[i] = pow[i - 1] * 10;
        long start = pow[(int)len - 1];
        long num = start + (nLong - 1) / len;
        int idx = (int)((nLong - 1) % len);
        return (int)((num / pow[(int)len - idx - 1]) % 10);
    }
}
