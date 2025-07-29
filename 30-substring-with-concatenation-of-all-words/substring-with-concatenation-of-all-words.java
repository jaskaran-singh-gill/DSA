class Solution {
    public List<Integer> findSubstring(String s, String[] words) 
    {
     List<Integer> output = new ArrayList<>();
        if (words.length == 0 || s.length() < words[0].length() * words.length) return output;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int sLen = s.length();

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= sLen) {
                String currWord = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(currWord)) {
                    windowMap.put(currWord, windowMap.getOrDefault(currWord, 0) + 1);
                    count++;

                    while (windowMap.get(currWord) > wordFreq.get(currWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == words.length) output.add(left);
                } else {
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return output;   
    }
}