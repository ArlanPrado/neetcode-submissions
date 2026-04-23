class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int forward = 0;
        int backward = s.length()-1;
        if(s.length() <= 1) {
            return true;
        }
        do {
            if(s.charAt(forward)!=(s.charAt(backward))) {
                return false;
            }
            ++forward;
            --backward;
        } while(forward < backward);
        return true;
    }
}
