class Solution {
    public int lengthOfLongestSubstring(String s) {
        String temp = "";
        int maxSubstr = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (temp.contains(""+s.charAt(i))) {
                if (temp.length() > maxSubstr) {
                    maxSubstr = temp.length();
                }
                temp = ""+s.charAt(i);
            } else {
                temp += s.charAt(i);
            }
        }
        if (counter > maxSubstr) {
            maxSubstr = counter;
        }
        return maxSubstr;
    }
}
