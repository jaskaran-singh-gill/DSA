import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) s[i] = String.valueOf(nums[i]);
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        if (s[0].charAt(0) == '0') return "0";
        int total = 0;
        for (String x : s) total += x.length();
        StringBuilder sb = new StringBuilder(total);
        for (String x : s) sb.append(x);
        return sb.toString();
    }
}
