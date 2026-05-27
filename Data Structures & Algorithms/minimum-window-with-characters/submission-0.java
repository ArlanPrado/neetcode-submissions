class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        int start = 0;
        int end = 0;
        
        // set up the map of String to character count
        Map<String, Integer> tCharMap = new HashMap<>();
        for (char tChar : t.toCharArray()) {
            tCharMap.merge("" + tChar, 1, (oldCount, newCount) -> oldCount + newCount);
        }
        
        String temp;
        // We use an active tracking map for the current window
        Map<String, Integer> windowMap = new HashMap<>();
        int matchedCount = 0; // Tracks how many required characters are matched

        // Your logic loop structure: look until end reaches the end of s
        while (end < s.length()) {
            temp = "" + s.charAt(end);
            
            // If the character is part of string t
            if (tCharMap.containsKey(temp)) {
                windowMap.merge(temp, 1, (oldCount, newCount) -> oldCount + newCount);
                
                // Only increment matchedCount if we still need this character 
                // (prevents over-counting duplicate characters already satisfied)
                if (windowMap.get(temp) <= tCharMap.get(temp)) {
                    matchedCount++;
                }
            }
            
            // When all characters are found (equivalent to your charLength == 0 condition)
            while (matchedCount == t.length()) {
                // Update result if it's empty or we found a shorter window
                String currentWindow = s.substring(start, end + 1);
                if (result.isEmpty() || currentWindow.length() < result.length()) {
                    result = currentWindow;
                }
                
                // Now try to move 'start' forward (your logic to find the next start position)
                String startChar = "" + s.charAt(start);
                if (tCharMap.containsKey(startChar)) {
                    windowMap.put(startChar, windowMap.get(startChar) - 1);
                    // If we drop below the required count for t, the window is no longer valid
                    if (windowMap.get(startChar) < tCharMap.get(startChar)) {
                        matchedCount--;
                    }
                }
                start++;
            }
            
            end++;
        }
        return result;
    }
}