import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        String res = s;
        q.offer(s);
        seen.add(s);
        int n = s.length();
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(res) < 0) res = cur;
            char[] arr = cur.toCharArray();
            for (int i = 1; i < n; i += 2) arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
            String add = new String(arr);
            if (seen.add(add)) q.offer(add);
            String rot = cur.substring(n - b) + cur.substring(0, n - b);
            if (seen.add(rot)) q.offer(rot);
        }
        return res;
    }
}
