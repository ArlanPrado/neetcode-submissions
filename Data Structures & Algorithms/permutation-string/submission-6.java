class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        s1 is a substring of s2 with characters in any order
        iterate through s2 after the end of the window to find a potential match.
        the last look should happen when s1.length <= s2.length - end window
        if found then do the same slide window strategy
        */
        //base case
        if (s1.length() > s2.length()) {
            return false;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (s1.contains("" + s2.charAt(i))) {
                int endWindow = i + 1;
                int s1Index = s1.indexOf("" + (s2.charAt(i)));
                String tempText = s1.substring(0, s1Index) + s1.substring(s1Index + 1);
                if (tempText.isEmpty()) {
                    return true;
                }

                boolean isStillFindable = true;
                while (isStillFindable) {
                    if (endWindow >= s2.length()) {
                        isStillFindable = false;
                        break;
                    }
                    
                    char possChar = s2.charAt(endWindow);
                    if (tempText.contains("" + possChar)) {
                        int innerIndex = tempText.indexOf("" + possChar);
                        tempText = tempText.substring(0, innerIndex) + tempText.substring(innerIndex + 1);
                    } else {
                        isStillFindable = false; 
                    }
                    
                    ++endWindow;
                    
                    if (tempText.length() <= 0) {
                        return true;
                    }
                }
                i = endWindow - 1;
            }
        }
        return false;
    }
}