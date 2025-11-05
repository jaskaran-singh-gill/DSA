class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
        }
        int missing = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        int[] mod = new int[3];
        int replace = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            char c = password.charAt(i);
            while (j < n && password.charAt(j) == c) j++;
            int len = j - i;
            if (len >= 3) {
                replace += len / 3;
                mod[len % 3]++;
            }
            i = j;
        }

        if (n < 6) return Math.max(missing, 6 - n);
        if (n <= 20) return Math.max(missing, replace);

        int del = n - 20;
        int use = Math.min(mod[0], del);
        replace -= use;
        del -= use;

        use = Math.min(mod[1] * 2, del);
        replace -= use / 2;
        del -= use;

        if (del > 0) replace -= del / 3;

        return (n - 20) + Math.max(missing, replace);
    }
}
