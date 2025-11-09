
class Solution {
    private final HashMap<Integer, int[]> map = new HashMap<>();

    public Solution(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) map.put(e.getKey(), new int[e.getValue()]);
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int p = cnt.get(v) - 1;
            map.get(v)[p] = i;
            cnt.put(v, p);
        }
    }
    
    public int pick(int target) {
        int[] a = map.get(target);
        return a[ThreadLocalRandom.current().nextInt(a.length)];
    }
}
