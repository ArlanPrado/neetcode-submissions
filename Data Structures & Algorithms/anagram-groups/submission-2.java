class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Using a map, use the key as the sorted word to compare then add the word to the list in the value
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String comparedWord = strs[i];
            String reSorted = reSort(comparedWord);
            List<String> valueList = anagramMap.get(reSorted);
            anagramMap.computeIfAbsent(reSorted, s -> {
                List<String> newList = new ArrayList<>();
                newList.add(comparedWord);
                return newList;
            });
            anagramMap.computeIfPresent(reSorted, (key, value) -> {
                if(!value.contains(comparedWord)){ 
                    value.add(comparedWord);
                }
                return value;
            });
        }
        return new ArrayList<>(anagramMap.values());

    }
    private String reSort(String originalString) {
        char[] charArray = originalString.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
