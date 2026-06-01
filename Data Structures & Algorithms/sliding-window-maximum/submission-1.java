class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            int result = 0;
            for (int n : nums) {
                result += n;
            }
            return new int[]{result};
        }

        int[] resultArr = new int[(nums.length - k + 1)];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int maxTemp = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (j >= nums.length) {
                    break;
                }
                if (maxTemp < nums[j]) {
                    maxTemp = nums[j];
                }
            }
            resultArr[i] = maxTemp;
        }
        return resultArr;
    }
}
