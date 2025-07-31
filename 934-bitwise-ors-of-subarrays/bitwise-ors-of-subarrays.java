class Solution {
    public int subarrayBitwiseORs(int[] arr) 
    {
         Set<Integer> globalSet = new HashSet<>();
        Set<Integer> prevSet = new HashSet<>();
        for (int num : arr) {
            Set<Integer> currSet = new HashSet<>();
            currSet.add(num);
            for (int val : prevSet) currSet.add(val | num);
            prevSet = currSet;
            globalSet.addAll(currSet);
        }
        return globalSet.size();
    }
}