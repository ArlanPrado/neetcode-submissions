class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<Integer,Integer>();
        for(int num : nums) {
            numToCount.merge(num, 1, Integer::sum);
        }
        List<Map.Entry<Integer, Integer>> temp = numToCount.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).toList();
        List<Integer> temp2 = new ArrayList<>();
        for(int i =0; i < k; i++){
            temp2.add(temp.get(i).getKey());
        }
        return temp2.stream().mapToInt(Integer::intValue).toArray();
    }
}
