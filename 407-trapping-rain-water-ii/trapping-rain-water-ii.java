class Solution {
    static final class MinHeap {
        int[] a = new int[1 << 15];
        int n = 0;
        void push(int v) {
            if (n == a.length) {
                int[] b = new int[a.length << 1];
                System.arraycopy(a, 0, b, 0, n);
                a = b;
            }
            int i = n++;
            a[i] = v;
            while (i > 0) {
                int p = (i - 1) >>> 1;
                if ((a[p] >>> 16) <= (a[i] >>> 16)) break;
                int t = a[p]; a[p] = a[i]; a[i] = t;
                i = p;
            }
        }
        int pop() {
            int res = a[0];
            int v = a[--n];
            int i = 0;
            while (true) {
                int l = i * 2 + 1, r = l + 1;
                if (l >= n) break;
                int m = l;
                if (r < n && (a[r] >>> 16) < (a[l] >>> 16)) m = r;
                if ((a[m] >>> 16) >= (v >>> 16)) break;
                a[i] = a[m];
                i = m;
            }
            a[i] = v;
            return res;
        }
        boolean isEmpty() { return n == 0; }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;
        boolean[] vis = new boolean[m * n];
        MinHeap pq = new MinHeap();
        for (int i = 0; i < m; i++) {
            int idx1 = i * n, idx2 = i * n + n - 1;
            vis[idx1] = true; vis[idx2] = true;
            pq.push((heightMap[i][0] << 16) | idx1);
            pq.push((heightMap[i][n - 1] << 16) | idx2);
        }
        for (int j = 1; j < n - 1; j++) {
            int idx1 = j, idx2 = (m - 1) * n + j;
            vis[idx1] = true; vis[idx2] = true;
            pq.push((heightMap[0][j] << 16) | idx1);
            pq.push((heightMap[m - 1][j] << 16) | idx2);
        }
        int ans = 0;
        int[] dir = {-1,0,1,0,-1};
        while (!pq.isEmpty()) {
            int key = pq.pop();
            int h = key >>> 16;
            int idx = key & 0xFFFF;
            int r = idx / n, c = idx % n;
            for (int t = 0; t < 4; t++) {
                int nr = r + dir[t], nc = c + dir[t + 1];
                if (nr <= 0 || nr >= m - 1 || nc <= 0 || nc >= n - 1) {
                    int ii = nr * n + nc;
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[ii]) {
                        vis[ii] = true;
                        int nh = heightMap[nr][nc];
                        pq.push(((nh < h ? h : nh) << 16) | ii);
                        if (nh < h) ans += h - nh;
                    }
                    continue;
                }
                int ii = nr * n + nc;
                if (vis[ii]) continue;
                vis[ii] = true;
                int nh = heightMap[nr][nc];
                pq.push(((nh < h ? h : nh) << 16) | ii);
                if (nh < h) ans += h - nh;
            }
        }
        return ans;
    }
}
