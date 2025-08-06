class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int max = 0;
        for (int v : nums) if (v > max) max = v;

        boolean[] prime = new boolean[max + 1];
        if (max >= 2) {
            java.util.Arrays.fill(prime, true);
            prime[0] = prime[1] = false;
            for (int i = 2; i * (long) i <= max; i++) if (prime[i]) {
                for (int j = i * i; j <= max; j += i) prime[j] = false;
            }
        }

        java.util.HashMap<Integer, java.util.ArrayList<Integer>> pos = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) pos.computeIfAbsent(nums[i], k -> new java.util.ArrayList<>()).add(i);

        boolean[] used = new boolean[max + 1];
        int[] dist = new int[n];
        java.util.Arrays.fill(dist, -1);
        int[] q = new int[n];
        int head = 0, tail = 0;
        dist[0] = 0;
        q[tail++] = 0;

        while (head < tail) {
            int i = q[head++];
            if (i == n - 1) return dist[i];
            int d = dist[i] + 1;

            if (i + 1 < n && dist[i + 1] == -1) {
                dist[i + 1] = d;
                q[tail++] = i + 1;
            }
            if (i - 1 >= 0 && dist[i - 1] == -1) {
                dist[i - 1] = d;
                q[tail++] = i - 1;
            }

            int v = nums[i];
            if (prime[v] && !used[v]) {
                for (int m = v; m <= max; m += v) {
                    java.util.ArrayList<Integer> list = pos.get(m);
                    if (list == null) continue;
                    for (int idx : list)
                        if (dist[idx] == -1) {
                            dist[idx] = d;
                            q[tail++] = idx;
                        }
                    pos.remove(m);
                }
                used[v] = true;
            }
        }
        return dist[n - 1];
    }
}
