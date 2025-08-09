class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        int[] path = new int[n];
        dfs(nums, used, path, 0, res);
        return res;
    }
    private void dfs(int[] nums, boolean[] used, int[] path, int d, List<List<Integer>> res) {
        if (d == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int v : path) list.add(v);
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path[d] = nums[i];
            dfs(nums, used, path, d + 1, res);
            used[i] = false;
        }
    }
}
