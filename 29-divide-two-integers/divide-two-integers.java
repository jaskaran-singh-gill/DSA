class Solution {
    public int divide(int dividend, int divisor) 
    {
     if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        while (a >= b) {
            long temp = b, count = 1;
            while ((temp << 1) <= a) {
                temp <<= 1;
                count <<= 1;
            }
            a -= temp;
            result += count;
        }

        return ((dividend ^ divisor) < 0) ? -result : result;   
    }
}