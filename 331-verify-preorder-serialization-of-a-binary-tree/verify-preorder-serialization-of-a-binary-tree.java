class Solution {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length(), i = 0, slots = 1;
        while (i < n) {
            if (slots == 0) return false;
            if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                slots--;
                while (i < n && preorder.charAt(i) != ',') i++;
                slots += 2;
            }
            if (i < n && preorder.charAt(i) == ',') i++;
        }
        return slots == 0;
    }
}
