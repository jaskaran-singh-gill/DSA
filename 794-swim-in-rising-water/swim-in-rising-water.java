import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length, target = n * n - 1;
        boolean[] vis = new boolean[n * n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{grid[0][0], 0});
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], idx = cur[1];
            if (vis[idx]) continue;
            vis[idx] = true;
            if (idx == target) return t;
            int r = idx / n, c = idx % n;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                int ni = nr * n + nc;
                if (vis[ni]) continue;
                int nt = Math.max(t, grid[nr][nc]);
                pq.add(new int[]{nt, ni});
            }
        }
        return -1;
    }
}
