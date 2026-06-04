class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        s1 is a substring of s2 with characters in any order
        first step: iterate through s2.charAt(s1[i]) to check for potential searchs
        slide window left and right until there are no more characters to look for in s1
        if left doesn't match then look right until it doesn't match or s1 runs out of chars to look for
        if this doesn't work, then look for next s2.charAt(s1[i]) again, but only if the index is after the sliding window

        if this strategy doesn't work then iterate through s2 after the end of the window to find a potential match.
        the last look should happen when s1.length <= s2.length - end window
        if found then do the same slide window strategy
        */
        //base case
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            if (s1.contains("" + s2.charAt(i))) {
                int endWindow = i + 1;
                String tempText = s1.replace("" + s2.charAt(i), "");
                boolean isStillFindable = true;
                while (isStillFindable) {
                    if (endWindow >= s2.length()) {
                        isStillFindable = false;
                    }
                    char possChar = s2.charAt(endWindow);
                    if (tempText.contains("" + possChar)) {
                        tempText = tempText.replace("" + s2.charAt(endWindow), "");
                    } else {
                        isStillFindable = false; 
                    }
                    endWindow++;
                    if (tempText.length() <= 0) {
                        return true;
                    }   
                }
                i = endWindow;
            }
        }
        return false;
    }
}
