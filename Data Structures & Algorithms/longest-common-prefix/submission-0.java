class Solution {
    public String longestCommonPrefix(String[] strs) {
        // loop through the array
        // after each iteration we should have at least a letter
        // if the last letter looked doesn't match the letter in the same position then return whatever is in the result

        String prefix = "";
        char letter;
        boolean canIterate = true;
        int charAt = 0;
        int wordAt = 0;
        while (charAt < strs.length) {
            letter = strs[0].charAt(charAt);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < charAt) {
                    return prefix;
                }
                if (letter != strs[i].charAt(charAt)) {
                    return prefix;
                }
            }
            prefix += letter;
            ++charAt;
        }
        return prefix;
    }
}