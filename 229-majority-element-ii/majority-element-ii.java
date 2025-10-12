class Solution {
    public java.util.List<Integer> majorityElement(int[] nums) {
        int n = nums.length, c1 = 0, c2 = 0, k1 = 0, k2 = 0;
        for (int x : nums) {
            if (k1 > 0 && x == c1) k1++;
            else if (k2 > 0 && x == c2) k2++;
            else if (k1 == 0) { c1 = x; k1 = 1; }
            else if (k2 == 0) { c2 = x; k2 = 1; }
            else { k1--; k2--; }
        }
        int s1 = 0, s2 = 0;
        for (int x : nums) {
            if (k1 > 0 && x == c1) s1++;
            else if (k2 > 0 && x == c2) s2++;
        }
        java.util.List<Integer> res = new java.util.ArrayList<>(2);
        if (k1 > 0 && s1 > n / 3) res.add(c1);
        if (k2 > 0 && c2 != c1 && s2 > n / 3) res.add(c2);
        return res;
    }
}
