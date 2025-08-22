import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length, m = n << 1, k = 0;
        int[][] e = new int[m][2];
        for (int[] b : buildings) { e[k][0] = b[0]; e[k++][1] = -b[2]; e[k][0] = b[1]; e[k++][1] = b[2]; }
        Arrays.sort(e, 0, k, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        TreeMap<Integer,Integer> cnt = new TreeMap<>();
        cnt.put(0, 1);
        int prev = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k;) {
            int x = e[i][0];
            while (i < k && e[i][0] == x) {
                int h = e[i][1];
                if (h < 0) {
                    int hh = -h;
                    Integer c = cnt.get(hh);
                    cnt.put(hh, c == null ? 1 : c + 1);
                } else {
                    Integer c = cnt.get(h);
                    if (c == 1) cnt.remove(h);
                    else cnt.put(h, c - 1);
                }
                i++;
            }
            int cur = cnt.lastKey();
            if (cur != prev) {
                ArrayList<Integer> p = new ArrayList<>(2);
                p.add(x); p.add(cur);
                res.add(p);
                prev = cur;
            }
        }
        return res;
    }
}
