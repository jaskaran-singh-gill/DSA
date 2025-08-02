class Solution {
    public long minCost(int[] basket1, int[] basket2) 
    {
     TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int x : basket1) freq.put(x, freq.getOrDefault(x, 0) + 1);
        for (int x : basket2) freq.put(x, freq.getOrDefault(x, 0) - 1);

        List<Integer> mismatch = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int v = e.getValue();
            if ((v & 1) != 0) return -1;
            for (int i = 0; i < Math.abs(v) / 2; i++) mismatch.add(e.getKey());
        }

        Collections.sort(mismatch);
        long minVal = freq.firstKey();
        long total = 0;
        int len = mismatch.size();
        for (int i = 0; i < len / 2; i++) {
            total += Math.min(mismatch.get(i), 2 * minVal);
        }

        return total;
           
    }
}