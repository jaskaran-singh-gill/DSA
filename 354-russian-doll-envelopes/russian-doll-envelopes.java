import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)-> a[0]==b[0]? Integer.compare(b[1],a[1]) : Integer.compare(a[0],b[0]));
        int n = envelopes.length, len = 0;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            int h = envelopes[i][1];
            int pos = Arrays.binarySearch(d, 0, len, h);
            if (pos < 0) pos = -pos - 1;
            d[pos] = h;
            if (pos == len) len++;
        }
        return len;
    }
}
