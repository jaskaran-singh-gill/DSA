class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        java.util.HashMap<Integer,Integer> cnt = new java.util.HashMap<>();
        for (int x : nums) cnt.put(x, cnt.getOrDefault(x,0) + 1);
        java.util.List<Integer>[] bucket = new java.util.ArrayList[n + 1];
        for (java.util.Map.Entry<Integer,Integer> e : cnt.entrySet()) {
            int f = e.getValue();
            if (bucket[f] == null) bucket[f] = new java.util.ArrayList<>();
            bucket[f].add(e.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = n; i >= 0 && idx < k; i--) {
            if (bucket[i] == null) continue;
            for (int v : bucket[i]) {
                res[idx++] = v;
                if (idx == k) break;
            }
        }
        return res;
    }
}
