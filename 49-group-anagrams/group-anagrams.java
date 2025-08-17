class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> m = new HashMap<>(n << 1);
        for (String s : strs) {
            int[] cnt = new int[26];
            for (int i = 0, L = s.length(); i < L; i++) cnt[s.charAt(i) - 'a']++;
            char[] k = new char[26];
            for (int i = 0; i < 26; i++) k[i] = (char) cnt[i];
            String key = new String(k);
            List<String> list = m.get(key);
            if (list == null) {
                list = new ArrayList<>();
                m.put(key, list);
            }
            list.add(s);
        }
        return new ArrayList<>(m.values());
    }
}
