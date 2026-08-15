class Solution {
    public boolean isPalindrome(String s) {
        String newString = "";
        for(char c : s.toCharArray()) {
            c = Character.toLowerCase(c);
            if(Character.isLetter(c)) {
                newString += c;
            }
        }

        s = newString;
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
