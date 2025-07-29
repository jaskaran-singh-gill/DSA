class Solution {
    public void nextPermutation(int[] nums) 
    {
       int n = nums.length, i = n - 2;
        
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        int left = i + 1, right = n - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }   
    }
}