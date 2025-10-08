import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length, n = spells.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long s = spells[i];
            long need = (success + s - 1) / s;
            int l = 0, r = m;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if ((long)potions[mid] >= need) r = mid; else l = mid + 1;
            }
            res[i] = m - l;
        }
        return res;
    }
}
