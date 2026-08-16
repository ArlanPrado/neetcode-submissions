class Solution {
    public boolean isPalindrome(String s) {
        String newString = "";
        for(char c : s.toCharArray()) {
            c = Character.toLowerCase(c);
            if(Character.isLetterOrDigit(c)) {
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
    /*
    Time Complexity: O(n) filtering letters + O(n/2) palindrome detect = O(n)
    Space Complexity: O(n), n being length of s. Temporarily have to hold the newly generated String after filtering non-alphanumericals
    */
}
