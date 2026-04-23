class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Using a map, use the key as the sorted word to compare then add the word to the list in the value
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String comparedWord = strs[i];
            String reSorted = reSort(comparedWord);
            List<String> valueList = anagramMap.get(reSorted);
            if (null == valueList) {
                List<String> newList = new ArrayList<>();
                newList.add(comparedWord);
                anagramMap.put(reSorted, newList);
            } else {
                valueList.add(comparedWord);
            }
        }
        return new ArrayList<>(anagramMap.values());

    }
    private String reSort(String originalString) {
        char[] charArray = originalString.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
