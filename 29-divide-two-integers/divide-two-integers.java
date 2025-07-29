class Solution {
    public int divide(int dividend, int divisor) 
    {
      if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int res = 0;
        for (int shift = 31; shift >= 0; shift--) {
            if ((a >> shift) >= b) {
                a -= b << shift;
                res += 1 << shift;
            }
        }
        return ((dividend ^ divisor) < 0) ? -res : res;   
    }
}