class Solution {
            /*
        thinking of a function, given a number, gets the possible combinations from that number..  
        0: []
        1: gets 1 number from the array..       this will have the most elements, so this will be nums.length
        2: gets 2 numbers from the array..      
            starts with 1 index, loops for each index not the 1 selected and returns each
        n.size: gets n numbers from the array / returns the whole list

        */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }

        for (int num : nums) {
            int resIndex = 0;
            List<List<Integer>> resultTemp = new ArrayList<>();
            while (resIndex < result.size()) {
                Integer[] temp = result.get(resIndex).toArray(new Integer[0]);
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = num;
                resultTemp.add(Arrays.asList(temp));
                ++resIndex;
            }
            result.addAll(resultTemp);
        }
        return result;
    }
}
