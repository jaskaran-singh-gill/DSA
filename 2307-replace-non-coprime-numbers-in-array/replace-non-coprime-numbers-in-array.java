import java.util.*;

class Solution {
    private long gcd(long a, long b){ while(b!=0){ long t=a%b; a=b; b=t; } return a; }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length, sz = 0;
        int[] st = new int[n];
        for (int v : nums) {
            long x = v;
            while (sz > 0) {
                long g = gcd(st[sz - 1], x);
                if (g == 1) break;
                x = (st[sz - 1] / g) * x;
                sz--;
            }
            st[sz++] = (int)x;
        }
        ArrayList<Integer> res = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) res.add(st[i]);
        return res;
    }
}
