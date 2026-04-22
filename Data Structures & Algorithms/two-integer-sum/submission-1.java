class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && (nums[i] + nums[j] == target)) {
                    sol[0] = i;
                    sol[1] = j;
                    break;
                }
            }
            if (-1 != sol[0]  && -1 != sol[1]) {
                break;
            }
        }
        return sol;
    }
}
