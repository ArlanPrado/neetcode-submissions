class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Object> numMap = new HashMap<>();
        for(int num : nums) {
            if (numMap.containsKey(num)) {
                return true;
            }
            numMap.put(num, null);
        }
        return false;
    }
}