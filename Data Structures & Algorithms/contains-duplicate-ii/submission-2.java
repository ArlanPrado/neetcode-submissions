class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // if there are two elements that are the same and their indices difference is less than or equal to k then return true 
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numMap.containsKey(num)) {
                int j = numMap.get(num);
                if (Math.abs(j - i) <= k) {
                    return true;
                }
            }
            numMap.put(num, i);
        }
        return false;
    }
    /*
    Time Complexity: O(n), On the false case it goes through the entire list
    Space Complexity: O(n), On the false case it would store the entire list in the map
    */
}