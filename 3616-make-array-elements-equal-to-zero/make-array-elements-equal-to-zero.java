class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (simulate(nums, i, -1)) ans++; 
                if (simulate(nums, i, 1)) ans++; 
            }
        }

        return ans;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();
        int curr = start;
        int direction = dir;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += direction;
            } else {
                arr[curr]--;
                direction = -direction;
                curr += direction;
            }
        }

    
        for (int val : arr) {
            if (val != 0) return false;
        }
        return true;
    }
}
