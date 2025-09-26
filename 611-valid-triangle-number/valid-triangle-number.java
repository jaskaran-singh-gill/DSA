import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int k = n - 1; k >= 2; k--) {
            if (nums[k] == 0) continue;
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    ans += j - i;
                    j--;
                } else i++;
            }
        }
        return ans;
    }
}

