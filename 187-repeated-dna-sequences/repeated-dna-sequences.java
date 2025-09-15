import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n < 10) return new ArrayList<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1; map['G' - 'A'] = 2; map['T' - 'A'] = 3;
        int mask = (1 << 20) - 1, code = 0;
        boolean[] seen = new boolean[1 << 20], added = new boolean[1 << 20];
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 9; i++) code = (code << 2) | map[s.charAt(i) - 'A'];
        for (int i = 9; i < n; i++) {
            code = ((code << 2) | map[s.charAt(i) - 'A']) & mask;
            if (!seen[code]) seen[code] = true;
            else if (!added[code]) { res.add(s.substring(i - 9, i + 1)); added[code] = true; }
        }
        return res;
    }
}
