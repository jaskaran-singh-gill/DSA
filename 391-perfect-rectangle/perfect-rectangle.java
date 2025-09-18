
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        long minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        long area = 0;
        HashSet<Long> set = new HashSet<>(n << 3);
        for (int[] r : rectangles) {
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            if (x1 >= x2 || y1 >= y2) return false;
            if (x1 < minX) minX = x1;
            if (y1 < minY) minY = y1;
            if (x2 > maxX) maxX = x2;
            if (y2 > maxY) maxY = y2;
            area += (long)(x2 - x1) * (y2 - y1);
            toggle(set, key(x1, y1));
            toggle(set, key(x1, y2));
            toggle(set, key(x2, y1));
            toggle(set, key(x2, y2));
        }
        long boundArea = (maxX - minX) * (maxY - minY);
        if (area != boundArea || set.size() != 4) return false;
        return set.contains(key((int)minX, (int)minY)) &&
               set.contains(key((int)minX, (int)maxY)) &&
               set.contains(key((int)maxX, (int)minY)) &&
               set.contains(key((int)maxX, (int)maxY));
    }
    private long key(int x, int y){ return ( (long)x << 32 ) ^ (y & 0xffffffffL); }
    private void toggle(HashSet<Long> s, long k){ if(!s.add(k)) s.remove(k); }
}
