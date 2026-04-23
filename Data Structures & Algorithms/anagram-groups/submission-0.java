class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //sequentially check first word with all other words
        //keep a list that omits indexes that have already been selected
        /*
        go through the list sequentially
        each word will be put in the list if it hasn't been encountered before
        if it has been encountered then put it in the list
        */
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            if (result.isEmpty()) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                result.add(newList);
            } else {
                String compared = strs[i];
                int foundList = -1;
                int iter = 0;
                for (List<String> eachList : result) {
                    String testStr = eachList.getFirst();
                    if (reSort(testStr).equals(reSort(compared))) {
                        foundList = iter;
                    }
                    iter++;
                }
                if (foundList != -1) {
                    result.get(foundList).add(strs[i]);
                } else {
                    addNewListToResult(result, strs[i]);
                }
            }
        }
        return result;
    }
    private String reSort(String originalString) {
        char[] charArray = originalString.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
    private void addNewListToResult(List<List<String>> result, String newWord) {
        List<String> newList = new ArrayList<>();
        newList.add(newWord);
        result.add(newList);
    }
}
