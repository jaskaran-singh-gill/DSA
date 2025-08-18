
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;
        if (!dict.contains(beginWord)) dict.add(beginWord);
        HashMap<String, List<String>> parents = new HashMap<>();
        HashSet<String> cur = new HashSet<>(), next = new HashSet<>(), visited = new HashSet<>();
        cur.add(beginWord);
        boolean found = false;
        int L = beginWord.length();
        while (!cur.isEmpty() && !found) {
            next.clear();
            for (String w : cur) visited.add(w);
            for (String w : cur) {
                char[] a = w.toCharArray();
                for (int i = 0; i < L; i++) {
                    char orig = a[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orig) continue;
                        a[i] = c;
                        String nw = new String(a);
                        if (!dict.contains(nw) || visited.contains(nw)) continue;
                        parents.computeIfAbsent(nw, k -> new ArrayList<>()).add(w);
                        if (nw.equals(endWord)) found = true;
                        next.add(nw);
                    }
                    a[i] = orig;
                }
            }
            cur.clear();
            cur.addAll(next);
        }
        if (!found) return res;
        ArrayDeque<String> path = new ArrayDeque<>();
        path.addLast(endWord);
        dfs(endWord, beginWord, parents, path, res);
        return res;
    }
    private void dfs(String word, String begin, Map<String, List<String>> parents, ArrayDeque<String> path, List<List<String>> res) {
        if (word.equals(begin)) {
            ArrayList<String> seq = new ArrayList<>(path.size());
            Iterator<String> it = path.descendingIterator();
            while (it.hasNext()) seq.add(it.next());
            res.add(seq);
            return;
        }
        List<String> ps = parents.get(word);
        if (ps == null) return;
        for (int i = 0, n = ps.size(); i < n; i++) {
            String p = ps.get(i);
            path.addLast(p);
            dfs(p, begin, parents, path, res);
            path.removeLast();
        }
    }
}
