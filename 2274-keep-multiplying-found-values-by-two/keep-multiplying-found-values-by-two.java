
class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>(nums.length * 2);
        for (int x : nums) set.add(x);
        while (set.contains(original)) original <<= 1;
        return original;
    }
}
