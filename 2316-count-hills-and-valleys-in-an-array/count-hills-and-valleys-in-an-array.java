class Solution {
    public int countHillValley(int[] nums) 
    {
       int count = 0;
        int i = 1;

        while (i < nums.length - 1) {
            int prev = i - 1;
            while (prev >= 0 && nums[prev] == nums[i]) prev--;

            int next = i + 1;
            while (next < nums.length && nums[next] == nums[i]) next++;

            if (prev >= 0 && next < nums.length) {
                if ((nums[i] > nums[prev] && nums[i] > nums[next]) ||
                    (nums[i] < nums[prev] && nums[i] < nums[next])) {
                    count++;
                }
            }

            i = next;
        }

        return count;
    }
}