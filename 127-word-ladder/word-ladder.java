
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
        HashSet<String> begin = new HashSet<>(), end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        dict.remove(endWord);
        int len = 1, L = beginWord.length();
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                HashSet<String> tmp = begin; begin = end; end = tmp;
            }
            HashSet<String> next = new HashSet<>();
            for (String w : begin) {
                char[] a = w.toCharArray();
                for (int i = 0; i < L; i++) {
                    char orig = a[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orig) continue;
                        a[i] = c;
                        String nw = new String(a);
                        if (end.contains(nw)) return len + 1;
                        if (dict.remove(nw)) next.add(nw);
                    }
                    a[i] = orig;
                }
            }
            begin = next;
            len++;
        }
        return 0;
    }
}
