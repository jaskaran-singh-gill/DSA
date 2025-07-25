class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, Integer> numMap = new HashMap<>();  // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No. two sum solution");
    }
}