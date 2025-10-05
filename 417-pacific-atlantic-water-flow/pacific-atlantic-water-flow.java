import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[] pac = new boolean[m * n], atl = new boolean[m * n];
        ArrayDeque<Integer> qp = new ArrayDeque<>(), qa = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int a = i * n, b = i * n + (n - 1);
            pac[a] = true; qp.add(a);
            atl[b] = true; qa.add(b);
        }
        for (int j = 0; j < n; j++) {
            int a = j, b = (m - 1) * n + j;
            if (!pac[a]) { pac[a] = true; qp.add(a); }
            if (!atl[b]) { atl[b] = true; qa.add(b); }
        }
        bfs(heights, qp, pac, m, n);
        bfs(heights, qa, atl, m, n);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int base = i * n;
            for (int j = 0; j < n; j++) {
                int idx = base + j;
                if (pac[idx] && atl[idx]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void bfs(int[][] h, ArrayDeque<Integer> q, boolean[] vis, int m, int n) {
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int idx = q.pollFirst();
            int r = idx / n, c = idx % n, hv = h[r][c];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                int ni = nr * n + nc;
                if (vis[ni]) continue;
                if (h[nr][nc] >= hv) { vis[ni] = true; q.addLast(ni); }
            }
        }
    }
}
