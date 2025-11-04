
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[51];
            for (int j = i; j < i + k; j++) freq[nums[j]]++;
            List<int[]> list = new ArrayList<>();
            for (int v = 1; v <= 50; v++) if (freq[v] > 0) list.add(new int[]{v, freq[v]});
            list.sort((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
            int sum = 0, cnt = 0;
            for (int[] p : list) {
                if (cnt == x) break;
                sum += p[0] * p[1];
                cnt++;
            }
            ans[i] = sum;
        }
        return ans;
    }
}
