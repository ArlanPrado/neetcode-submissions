class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> word1Map = wordToCharMap(s);
        Map<Character, Integer> word2Map = wordToCharMap(t);
        return word1Map.equals(word2Map);
    }
    private Map<Character, Integer> wordToCharMap (String word) {
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        for (int i = 0; i < word.length(); i++) {
            Character temp = word.charAt(i);
            Integer count = charCountMap.putIfAbsent(temp, 0);
            if (null != count) {
                charCountMap.put(temp, ++count);
            }
        }
        return charCountMap;
    }
}
