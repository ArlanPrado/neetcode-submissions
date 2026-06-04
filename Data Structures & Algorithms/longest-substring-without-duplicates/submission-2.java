class Solution {
    public int lengthOfLongestSubstring(String s) {
        String temp = "";
        int maxSubstr = 0;
        int substrStart = 1;
        for (int i = 0; i < s.length(); i++) {

            if (temp.contains(""+s.charAt(i))) {
                if (temp.length() > maxSubstr) {
                    maxSubstr = temp.length();
                }
                temp = ""+s.charAt(i);
                i = substrStart;
                ++substrStart;
            } else {
                temp += s.charAt(i);
            }
        }
        if (temp.length() > maxSubstr) {
            maxSubstr = temp.length();
        }
        return maxSubstr;
    }
}
