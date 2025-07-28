class Solution {
    public int countMaxOrSubsets(int[] nums) 
    {
        int max = 0;
        for (int val : nums) max |= val;

        int[] result = new int[1];
        dfs(nums, 0, 0, max, result);
        return result[0];
    }

    private void dfs(int[] nums, int index, int orValue, int target, int[] result) {
        if (index == nums.length) {
            if (orValue == target) result[0]++;
            return;
        }
        dfs(nums, index + 1, orValue | nums[index], target, result);
        dfs(nums, index + 1, orValue, target, result);
    }
}