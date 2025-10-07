class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        java.util.HashMap<Integer, Integer> last = new java.util.HashMap<>();
        java.util.TreeSet<Integer> dry = new java.util.TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x = rains[i];
            if (x > 0) {
                Integer p = last.get(x);
                if (p != null) {
                    Integer d = dry.higher(p);
                    if (d == null) return new int[0];
                    ans[d] = x;
                    dry.remove(d);
                }
                ans[i] = -1;
                last.put(x, i);
            } else {
                dry.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
