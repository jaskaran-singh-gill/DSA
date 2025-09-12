class Solution {
    public int compareVersion(String version1, String version2) {
        char[] a = version1.toCharArray(), b = version2.toCharArray();
        int n1 = a.length, n2 = b.length, i = 0, j = 0;
        while (i < n1 || j < n2) {
            int x = 0, y = 0;
            while (i < n1 && a[i] != '.') { x = x * 10 + (a[i] - '0'); i++; }
            while (j < n2 && b[j] != '.') { y = y * 10 + (b[j] - '0'); j++; }
            if (x < y) return -1;
            if (x > y) return 1;
            i++; j++;
        }
        return 0;
    }
}
