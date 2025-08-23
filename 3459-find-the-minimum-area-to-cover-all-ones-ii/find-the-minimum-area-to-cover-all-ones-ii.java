import java.util.*;
class Solution {
    public int minimumSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        List<int[]> ones = new ArrayList<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (grid[i][j] == 1) ones.add(new int[]{i, j});
        if (ones.size() < 3) return Integer.MAX_VALUE;

        java.util.function.ToIntFunction<List<int[]>> area = subset -> {
            int minr = Integer.MAX_VALUE, maxr = Integer.MIN_VALUE;
            int minc = Integer.MAX_VALUE, maxc = Integer.MIN_VALUE;
            for (int[] p : subset) {
                minr = Math.min(minr, p[0]);
                maxr = Math.max(maxr, p[0]);
                minc = Math.min(minc, p[1]);
                maxc = Math.max(maxc, p[1]);
            }
            return (maxr - minr + 1) * (maxc - minc + 1);
        };

        int ans = Integer.MAX_VALUE;

        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = c1 + 1; c2 < m; c2++) {
                List<int[]> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
                for (int[] p : ones) {
                    if (p[1] <= c1) a.add(p);
                    else if (p[1] <= c2) b.add(p);
                    else c.add(p);
                }
                if (!a.isEmpty() && !b.isEmpty() && !c.isEmpty()) {
                    ans = Math.min(ans, area.applyAsInt(a) + area.applyAsInt(b) + area.applyAsInt(c));
                }
            }
        }

        for (int r1 = 0; r1 < n; r1++) {
            for (int r2 = r1 + 1; r2 < n; r2++) {
                List<int[]> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
                for (int[] p : ones) {
                    if (p[0] <= r1) a.add(p);
                    else if (p[0] <= r2) b.add(p);
                    else c.add(p);
                }
                if (!a.isEmpty() && !b.isEmpty() && !c.isEmpty()) {
                    ans = Math.min(ans, area.applyAsInt(a) + area.applyAsInt(b) + area.applyAsInt(c));
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                List<int[]> a = new ArrayList<>(), b = new ArrayList<>(), d = new ArrayList<>();
                for (int[] p : ones) {
                    if (p[0] <= r) a.add(p);
                    else if (p[1] <= c) b.add(p);
                    else d.add(p);
                }
                if (!a.isEmpty() && !b.isEmpty() && !d.isEmpty()) {
                    ans = Math.min(ans, area.applyAsInt(a) + area.applyAsInt(b) + area.applyAsInt(d));
                }
                a.clear(); b.clear(); d.clear();
                for (int[] p : ones) {
                    if (p[0] > r) a.add(p);
                    else if (p[1] <= c) b.add(p);
                    else d.add(p);
                }
                if (!a.isEmpty() && !b.isEmpty() && !d.isEmpty()) {
                    ans = Math.min(ans, area.applyAsInt(a) + area.applyAsInt(b) + area.applyAsInt(d));
                }
                a = new ArrayList<>(); b = new ArrayList<>(); d = new ArrayList<>();
                for (int[] p : ones) {
                    if (p[1] <= c) a.add(p);
                    else if (p[0] <= r) b.add(p);
                    else d.add(p);
                }
                if (!a.isEmpty() && !b.isEmpty() && !d.isEmpty()) {
                    ans = Math.min(ans, area.applyAsInt(a) + area.applyAsInt(b) + area.applyAsInt(d));
                }
                a.clear(); b.clear(); d.clear();
                for (int[] p : ones) {
                    if (p[1] > c) a.add(p);
                    else if (p[0] <= r) b.add(p);
                    else d.add(p);
                }
                if (!a.isEmpty() && !b.isEmpty() && !d.isEmpty()) {
                    ans = Math.min(ans, area.applyAsInt(a) + area.applyAsInt(b) + area.applyAsInt(d));
                }
            }
        }

        return ans;
    }
}
