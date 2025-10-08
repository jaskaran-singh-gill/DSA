import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (n1 == 0 || n2 == 0 || k == 0) return res;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        int lim = Math.min(k, n1);
        for (int i = 0; i < lim; i++) pq.add(new long[]{(long)nums1[i] + nums2[0], i, 0});
        while (k-- > 0 && !pq.isEmpty()) {
            long[] cur = pq.poll();
            int i = (int)cur[1], j = (int)cur[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < n2) pq.add(new long[]{cur[0] - nums2[j] + nums2[j + 1], i, j + 1});
        }
        return res;
    }
}
