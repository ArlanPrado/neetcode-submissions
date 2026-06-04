class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<Integer,Integer>();
        for(int num : nums) {
            numToCount.merge(num, 1, Integer::sum);
        }
        List<Integer> temp = new ArrayList<>();
        numToCount.entrySet().forEach(entry -> {
            if(entry.getValue() >= k) {
                temp.add(entry.getKey());
            }
        });
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
