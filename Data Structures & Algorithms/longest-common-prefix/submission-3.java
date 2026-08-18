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
        while (charAt < strs[0].length()) {
            letter = strs[0].charAt(charAt);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= charAt) {
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

    // Time Complexity: O(n * m) with n being the number of strings and m being the length of the shortest string. Worst case if all Strings are the same length
    // Space Complexity: O(1) Stores the result only.
}