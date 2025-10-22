
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        HashMap<Long, Integer> events = new HashMap<>();
        HashMap<Long, Integer> exact = new HashMap<>();
        for (int v : nums) {
            long L = (long) v - k;
            long R = (long) v + k + 1;
            events.put(L, events.getOrDefault(L, 0) + 1);
            events.put(R, events.getOrDefault(R, 0) - 1);
            exact.put((long) v, exact.getOrDefault((long) v, 0) + 1);
        }
        TreeSet<Long> keySet = new TreeSet<>();
        keySet.addAll(events.keySet());
        keySet.addAll(exact.keySet());
        ArrayList<Long> keys = new ArrayList<>(keySet);
        long cur = 0;
        int ans = 0;
        for (int i = 0; i < keys.size(); i++) {
            long key = keys.get(i);
            Integer ev = events.get(key);
            if (ev != null) cur += ev;
            int cntExact = exact.getOrDefault(key, 0);
            int possible = (int) Math.min(cur, cntExact + (long) numOperations);
            if (possible > ans) ans = possible;
            if (i + 1 < keys.size()) {
                long next = keys.get(i + 1);
                if (next - key > 1) {
                    int possible2 = (int) Math.min(cur, (long) numOperations);
                    if (possible2 > ans) ans = possible2;
                }
            }
        }
        return ans;
    }
}
