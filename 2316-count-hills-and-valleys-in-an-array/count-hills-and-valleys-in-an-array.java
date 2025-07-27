class Solution {
    public int countHillValley(int[] nums) 
    {List<Integer> simplified = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                simplified.add(nums[i]);
            }
        }

        int terrainFeatures = 0;
        for (int i = 1; i < simplified.size() - 1; i++) {
            int left = simplified.get(i - 1);
            int current = simplified.get(i);
            int right = simplified.get(i + 1);

            if ((current > left && current > right) || (current < left && current < right)) {
                terrainFeatures++;
            }
        }

        return terrainFeatures;
    }
}