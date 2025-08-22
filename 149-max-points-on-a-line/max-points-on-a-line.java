import java.util.*;
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int ans = 2;
        HashMap<Long,Integer> map = new HashMap<>(n << 2);
        for (int i = 0; i < n; i++) {
            if (ans >= n - i) break;
            map.clear();
            int xi = points[i][0], yi = points[i][1];
            int local = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - xi, dy = points[j][1] - yi;
                if (dx == 0) { dy = 1; }
                else if (dy == 0) { dx = 1; }
                else {
                    if (dx < 0) { dx = -dx; dy = -dy; }
                    int g = gcd(dy, dx);
                    dy /= g; dx /= g;
                }
                long key = (((long)dy) << 32) | (dx & 0xffffffffL);
                int c = map.getOrDefault(key, 0) + 1;
                map.put(key, c);
                if (c > local) local = c;
            }
            int cand = local + 1;
            if (cand > ans) ans = cand;
        }
        return ans;
    }
    private int gcd(int a, int b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        while (b != 0) { int t = a % b; a = b; b = t; }
        return a;
    }
}
