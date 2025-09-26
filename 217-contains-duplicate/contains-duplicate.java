
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>(Math.max(16, (int)(n / 0.75f) + 1));
        for (int x : nums) if (!set.add(x)) return true;
        return false;
    }
}
