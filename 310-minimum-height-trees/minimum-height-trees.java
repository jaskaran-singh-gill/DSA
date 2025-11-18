import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        int[] deg = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
            deg[u]++;
            deg[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (deg[i] == 1) q.offer(i);
        int remaining = n;
        while (remaining > 2) {
            int size = q.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (--deg[v] == 1) q.offer(v);
                }
            }
        }
        res.addAll(q);
        return res;
    }
}
