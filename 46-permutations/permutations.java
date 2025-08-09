class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }
    private void backtrack(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) list.add(num);
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int tmp = nums[start]; nums[start] = nums[i]; nums[i] = tmp;
            backtrack(nums, start + 1, res);
            tmp = nums[start]; nums[start] = nums[i]; nums[i] = tmp;
        }
    }
}
