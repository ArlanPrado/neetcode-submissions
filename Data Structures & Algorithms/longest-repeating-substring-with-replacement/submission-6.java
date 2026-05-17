class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charToCount = new HashMap<>();
        char[] charArray = s.toCharArray();
        int end = 0;
        int result = 0;
        // Setting most common outside window to allow a historical limit during next iterations of the sliding window
        int mostCommon = 0;
        for (int i = 0; i < charArray.length; ++i) {
            boolean isAtLimit = false;
            
            while (!isAtLimit) {
                // Check bounds BEFORE adding a new character
                if (end >= charArray.length) {
                    isAtLimit = true;
                    break;
                }

                charToCount.merge(charArray[end], 1, Integer::sum);
                int currentCount = charToCount.get(charArray[end]);
                end++; 

                // Every iteration it compares the most common count 
                mostCommon = Math.max(mostCommon, currentCount);
                int nonCommon = end - i - mostCommon;
                
                
                if (nonCommon > k) {
                    isAtLimit = true;
                }
            }
            
            // Record the maximum valid length found so far
            // If the while loop broke because nonCommon > k, 'end' overshot by 1, so we subtract 1
            int currentLength = (end - i);
            if (mostCommon + k < currentLength) {
                currentLength--; 
            }
            result = Math.max(result, currentLength);
            
            // Shrink window from the LEFT side (i) to move the sliding window
            charToCount.merge(charArray[i], -1, Integer::sum);
        }
        return result;
    }
}