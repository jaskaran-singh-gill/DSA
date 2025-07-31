class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        findCombos(candidates, target, 0, new ArrayList<>(), output);
        return output;
    }

    private void findCombos(int[] pool, int remain, int pos, List<Integer> build, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(build));
            return;
        }
        for (int i = pos; i < pool.length && pool[i] <= remain; i++) {
            build.add(pool[i]);
            findCombos(pool, remain - pool[i], i, build, result);
            build.remove(build.size() - 1);
        }
    }
}