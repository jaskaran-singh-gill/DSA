
class Solution {
    static final class Node {
        int[] nxt = new int[26];
        int end = -1;
        int[] pal = new int[4];
        int psz = 0;
        Node() { Arrays.fill(nxt, -1); }
        void addPal(int idx){
            if (psz == pal.length) pal = Arrays.copyOf(pal, psz << 1);
            pal[psz++] = idx;
        }
    }

    private boolean isPal(char[] s, int l, int r){
        while (l < r) if (s[l++] != s[r--]) return false;
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        ArrayList<Node> trie = new ArrayList<>(n * 4 + 4);
        trie.add(new Node());
        for (int i = 0; i < n; i++) {
            char[] w = words[i].toCharArray();
            int u = 0;
            for (int j = w.length - 1; j >= 0; j--) {
                if (isPal(w, 0, j)) trie.get(u).addPal(i);
                int c = w[j] - 'a';
                int v = trie.get(u).nxt[c];
                if (v == -1) { v = trie.size(); trie.get(u).nxt[c] = v; trie.add(new Node()); }
                u = v;
            }
            trie.get(u).end = i;
            trie.get(u).addPal(i);
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] w = words[i].toCharArray();
            int u = 0, j = 0, L = w.length;
            while (j < L) {
                if (trie.get(u).end != -1 && trie.get(u).end != i && isPal(w, j, L - 1))
                    res.add(Arrays.asList(i, trie.get(u).end));
                int c = w[j] - 'a';
                int v = trie.get(u).nxt[c];
                if (v == -1) { u = -1; break; }
                u = v; j++;
            }
            if (u == -1) continue;
            Node node = trie.get(u);
            for (int t = 0; t < node.psz; t++) {
                int idx = node.pal[t];
                if (idx != i) res.add(Arrays.asList(i, idx));
            }
        }
        return res;
    }
}
