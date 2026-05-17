class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charToCount = new HashMap<>();
        char[] charArray = s.toCharArray();
        int end = 0;
        int result = 0;

        for (int i = 0; i < charArray.length; ++i) {
            boolean isAtLimit = false;
            
            while (!isAtLimit) {
                // 1. Check bounds BEFORE adding a new character
                if (end >= charArray.length) {
                    isAtLimit = true;
                    break;
                }

                charToCount.merge(charArray[end], 1, Integer::sum);
                
                // 2. Window math uses (end - i + 1) because 'end' hasn't incremented yet
                int mostCommon = charToCount.values().stream().max(Integer::compare).orElse(0);
                int nonCommon = (end - i + 1) - mostCommon;
                
                end++; // Move right pointer forward AFTER calculating math
                
                if (nonCommon > k) {
                    isAtLimit = true;
                }
            }
            
            // 3. Record the maximum valid length found so far
            // If the while loop broke because nonCommon > k, 'end' overshot by 1, so we subtract 1
            int currentLength = (end - i);
            if (charToCount.values().stream().max(Integer::compare).orElse(0) + k < currentLength) {
                currentLength--; 
            }
            result = Math.max(result, currentLength);
            
            // 4. FIX: Shrink window from the LEFT side (i), not the right side (end)
            charToCount.merge(charArray[i], -1, Integer::sum);
        }
        return result;
    }
}