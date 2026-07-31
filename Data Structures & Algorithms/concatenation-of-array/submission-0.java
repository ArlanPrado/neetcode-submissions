class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            newNums[nums.length + i] = nums[i];
        }
        return newNums;
    }
}