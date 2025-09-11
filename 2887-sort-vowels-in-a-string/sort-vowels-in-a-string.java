class Solution {
    public String sortVowels(String s) {
        char[] a = s.toCharArray();
        boolean[] is = new boolean[128];
        is['A']=is['E']=is['I']=is['O']=is['U']=is['a']=is['e']=is['i']=is['o']=is['u']=true;
        int[] cnt = new int[128];
        for (char c : a) if (c < 128 && is[c]) cnt[c]++;
        char[] ord = {'A','E','I','O','U','a','e','i','o','u'};
        int p = 0;
        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if (c < 128 && is[c]) {
                while (p < 10 && cnt[ord[p]] == 0) p++;
                a[i] = ord[p];
                cnt[ord[p]]--;
            }
        }
        return new String(a);
    }
}
