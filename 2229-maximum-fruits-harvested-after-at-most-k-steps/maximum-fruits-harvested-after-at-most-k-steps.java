class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) 
    {
     int n = fruits.length, maxHarvest = 0, left = 0, right = 0, currSum = 0;
        
        while (right < n) {
            currSum += fruits[right][1];
            while (left <= right && !reachable(fruits[left][0], fruits[right][0], startPos, k)) {
                currSum -= fruits[left++][1];
            }
            maxHarvest = Math.max(maxHarvest, currSum);
            right++;
        }
        
        return maxHarvest;
    }

    private boolean reachable(int lPos, int rPos, int sPos, int maxSteps) {
        int distLeftFirst = Math.abs(sPos - lPos) + (rPos - lPos);
        int distRightFirst = Math.abs(sPos - rPos) + (rPos - lPos);
        return Math.min(distLeftFirst, distRightFirst) <= maxSteps;   
    }
}