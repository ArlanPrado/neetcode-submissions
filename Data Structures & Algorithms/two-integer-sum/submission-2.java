class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(numToIndex.containsKey(complement)) {
                int[] sol = {numToIndex.get(complement), i};
                return sol;
            }
            numToIndex.put(nums[i], i);
        }
        int[] fallback = {-1,-1};
        return fallback;
    }
}
