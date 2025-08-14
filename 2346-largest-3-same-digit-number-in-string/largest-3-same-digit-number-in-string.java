class Solution {
    public String largestGoodInteger(String num) {
        char[] a = num.toCharArray();
        int n = a.length - 2;
        char best = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            char c = a[i];
            if (c == a[i + 1] && c == a[i + 2]) {
                if (!found || c > best) {
                    best = c;
                    found = true;
                    if (best == '9') break;
                }
            }
        }
        if (!found) return "";
        return new String(new char[]{best, best, best});
    }
}
